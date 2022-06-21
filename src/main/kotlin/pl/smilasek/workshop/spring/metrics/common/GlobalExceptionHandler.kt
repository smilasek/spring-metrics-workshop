package pl.smilasek.workshop.spring.metrics.common

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(value = [Exception::class])
    fun handleException(ex: Exception) = ErrorResponse(ex)
}

data class ErrorResponse(val type: Class<*>, val reason: String?) {
    constructor(ex: Exception) : this(type = ex.javaClass, reason = ex.message)
}