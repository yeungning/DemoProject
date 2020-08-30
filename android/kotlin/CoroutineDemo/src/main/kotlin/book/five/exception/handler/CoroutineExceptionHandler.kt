package book.five.exception.handler

import java.lang.Exception
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

interface CoroutineExceptionHandler  : CoroutineContext.Element{
    companion object Key : CoroutineContext.Key<CoroutineExceptionHandler>

    fun handleException(context: CoroutineContext , exception: Throwable)
}


inline fun CoroutineExceptionHandler(
        crossinline handler : (CoroutineContext , Throwable) -> Unit
) : CoroutineExceptionHandler = object : AbstractCoroutineContextElement(CoroutineExceptionHandler) , CoroutineExceptionHandler{
    override fun handleException(context: CoroutineContext, exception: Throwable) {
        handler.invoke(context , exception)
    }
}