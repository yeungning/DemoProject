package book.five

import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext


/**
 * AbstractCoroutine
 */


abstract class AbstractCoroutine <T>(context: CoroutineContext) : Job , Continuation<T> {


    protected val state = AtomicReference<CoroutineState>()

    override val context: CoroutineContext

    init {
        state.set(CoroutineState.Incomplete())
        this.context = context + this
    }

    val isComplete
    get() = state.get() is CoroutineState.Complete<*>

    override val isActive: Boolean
    get() = when (state.get()) {
        is CoroutineState.Complete<*>,
        is CoroutineState.Cancelling -> false
        else -> true
    }

    override fun invokeOnCancel(onCancel: OnCancel) : Disposable {
        TODO("Not yet implemented")
    }

    override fun invokeOnComplete(onComplete: OnComplete) : Disposable {
        return doOnCompleted { _ -> onComplete() }
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }

    override fun remove(disposable: Disposable) {
        state.updateAndGet{prev ->
            when(prev){
                is CoroutineState.Incomplete ->{
                    CoroutineState.Incomplete().from(prev).with(disposable)
                }
                is CoroutineState.Cancelling ->{
                    CoroutineState.Cancelling().from(prev).with(disposable)
                }
                is CoroutineState.Complete<*> -> prev
            }
        }
    }

    override suspend fun join() {
        TODO("Not yet implemented")
    }

    override fun resumeWith(result: Result<T>) {
        val newState = state.updateAndGet{prevState ->
            when(prevState){
                is CoroutineState.Incomplete,
                is CoroutineState.Cancelling ->{
                    CoroutineState.Complete(result.getOrNull(),
                            result.exceptionOrNull()).from(prevState)
                }
                is CoroutineState.Complete<*> ->{
                    throw java.lang.IllegalStateException("Already Complete!")
                }
            }

        }
        newState.notifyCompletion(result)
        newState.clear()
    }

    @Suppress("UNCHECKED_CAST")
    protected fun doOnCompleted(block : (Result<T>) -> Unit) : Disposable {
        val disposable  = CompletionHandleDispose(this,block)
        val newState = state.updateAndGet{ prev ->
            when(prev){
                is CoroutineState.Incomplete ->{
                    CoroutineState.Incomplete().from(prev).with(disposable)
                }
                is CoroutineState.Cancelling ->{
                    CoroutineState.Cancelling().from(prev).with(disposable)
                }
                is CoroutineState.Complete<*> -> prev
            }
        }

        (newState as? CoroutineState.Complete<T>)?.let {
            block(
                    when{
                        it.value!=null -> Result.success(it.value)
                        it.exception!=null -> Result.failure(it.exception)
                        else -> throw  IllegalStateException("Wont`t Happen")
                    }
            )
        }

        return disposable
    }
}