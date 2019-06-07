package com.melardev.spring.restcrud.dtos.responses

class SuccessResponse constructor(message: String) : AppResponse(true) {

    init {
        addFullMessage(message)
    }
}
