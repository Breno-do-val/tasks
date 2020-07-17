package com.example.tasks.service.constants

/**
 * Constants used in application
 */
class TaskConstants private constructor() {

    // SharedPreferences
    object SHARED {
        const val TOKEN_KEY = "tokenkey"
        const val PERSON_KEY = "personkey"
        const val PERSON_NAME = "personname"
    }

    // API Request
    object HEADER {
        const val TOKEN_KEY = "token"
        const val PERSON_KEY = "personkey"
    }

    object HTTP {
        const val SUCCESS = 200
    }

    object BUNDLE {
        const val TASKID = "taskid"
        const val TASKFILTER = "taskfilter"
    }

    object FILTER {
        const val ALL = 0
        const val NEXT = 1
        const val EXPIRED = 2
    }

}