package com.example.tasks.service.listener

import com.example.tasks.service.model.HeaderModel

interface APIListener {

    fun onSucess(model: HeaderModel)

    fun onFailure(str: String)
}