//package me.potato.simplerestfulapi.controller
//
//import org.aspectj.lang.JoinPoint
//import org.aspectj.lang.annotation.AfterThrowing
//import org.springframework.beans.factory.annotation.Value
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.web.bind.MethodArgumentNotValidException
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.context.request.WebRequest
//
//class UserAdvice(private val kt: KafkaTemplate<String, String>) {
//
//    @Value("\${app.kafka.topic}")
//    private lateinit var topic: String
//
//    @ExceptionHandler(MethodArgumentNotValidException::class)
//    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException, req: WebRequest): ErrResponse {
//        return ErrResponse(ex.bindingResult.allErrors.joinToString(", ") { it.defaultMessage ?: "" })
//    }
//
//    @AfterThrowing(pointcut = "execution(* me.potato.simplerestfulapi.service.UserService.*(..))", throwing = "ex")
//    fun handleServiceException(jp: JoinPoint, ex: Exception) {
//        val methodName = jp.signature.name
//        val args = jp.args
//        val userId = if (args.isNotEmpty()) args[0] else "unknown"
//        val eventKey = "exception"
//        val eventType = "event.$methodName"
//        val eventValue = ex.message ?: "unknown"
//
//        val event = "$eventKey:$eventType:$userId:$eventValue"
//        kt.send(topic, event)
//    }
//
//}