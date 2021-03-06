package cn.youngning.retrofitsourcedemo.net

data class Owner(val gistsUrl: String = "",
                 val reposUrl: String = "",
                 val followingUrl: String = "",
                 val starredUrl: String = "",
                 val login: String = "",
                 val followersUrl: String = "",
                 val type: String = "",
                 val url: String = "",
                 val subscriptionsUrl: String = "",
                 val receivedEventsUrl: String = "",
                 val avatarUrl: String = "",
                 val eventsUrl: String = "",
                 val htmlUrl: String = "",
                 val siteAdmin: Boolean = false,
                 val id: Int = 0,
                 val gravatarId: String = "",
                 val nodeId: String = "",
                 val organizationsUrl: String = "")


data class Repo(val stargazersCount: Int = 0,
                val pushedAt: String = "",
                val subscriptionUrl: String = "",
                val language: String = "",
                val branchesUrl: String = "",
                val issueCommentUrl: String = "",
                val labelsUrl: String = "",
                val subscribersUrl: String = "",
                val releasesUrl: String = "",
                val svnUrl: String = "",
                val id: Int = 0,
                val forks: Int = 0,
                val archiveUrl: String = "",
                val gitRefsUrl: String = "",
                val forksUrl: String = "",
                val statusesUrl: String = "",
                val sshUrl: String = "",
                val license: String = "",
                val fullName: String = "",
                val size: Int = 0,
                val languagesUrl: String = "",
                val htmlUrl: String = "",
                val collaboratorsUrl: String = "",
                val cloneUrl: String = "",
                val name: String = "",
                val pullsUrl: String = "",
                val defaultBranch: String = "",
                val hooksUrl: String = "",
                val treesUrl: String = "",
                val tagsUrl: String = "",
                val private: Boolean = false,
                val contributorsUrl: String = "",
                val hasDownloads: Boolean = false,
                val notificationsUrl: String = "",
                val openIssuesCount: Int = 0,
                val description: String = "",
                val createdAt: String = "",
                val watchers: Int = 0,
                val keysUrl: String = "",
                val deploymentsUrl: String = "",
                val hasProjects: Boolean = false,
                val archived: Boolean = false,
                val hasWiki: Boolean = false,
                val updatedAt: String = "",
                val commentsUrl: String = "",
                val stargazersUrl: String = "",
                val disabled: Boolean = false,
                val gitUrl: String = "",
                val hasPages: Boolean = false,
                val owner: Owner,
                val commitsUrl: String = "",
                val compareUrl: String = "",
                val gitCommitsUrl: String = "",
                val blobsUrl: String = "",
                val gitTagsUrl: String = "",
                val mergesUrl: String = "",
                val downloadsUrl: String = "",
                val hasIssues: Boolean = false,
                val url: String = "",
                val contentsUrl: String = "",
                val mirrorUrl: String = "",
                val milestonesUrl: String = "",
                val teamsUrl: String = "",
                val fork: Boolean = false,
                val issuesUrl: String = "",
                val eventsUrl: String = "",
                val issueEventsUrl: String = "",
                val assigneesUrl: String = "",
                val openIssues: Int = 0,
                val watchersCount: Int = 0,
                val nodeId: String = "",
                val homepage: String = "",
                val forksCount: Int = 0)


