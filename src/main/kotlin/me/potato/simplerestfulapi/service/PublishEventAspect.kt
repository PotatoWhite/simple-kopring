//package me.potato.simplerestfulapi.service
//
//import org.aspectj.lang.ProceedingJoinPoint
//import org.aspectj.lang.annotation.Around
//import org.aspectj.lang.annotation.Aspect
//import org.aspectj.lang.annotation.Pointcut
//import org.springframework.kafka.core.KafkaTemplate
//import org.springframework.kafka.support.KafkaHeaders
//import org.springframework.messaging.support.MessageBuilder
//import org.springframework.stereotype.Component
//
//@Aspect
//@Component
//class PublishEventAspect(private val kt: KafkaTemplate<String, String>) {
//
//    @Pointcut("@annotation(com.example.PublishEvent)")
//    fun publishEventPointcut() {
//    }
//
//    @Around("publishEventPointcut()")
//    @Throws(Throwable::class)
//    fun aroundPublishEvent(joinPoint: ProceedingJoinPoint): Any? {
//        val result = joinPoint.proceed()
//
//        val signature = joinPoint.signature
//        val eventKey = signature.name
//        val eventType = "event.$eventKey"
//        val eventValue = result.toString()
//
//        val msg = MessageBuilder
//                .withPayload(eventValue)
//                .setHeader(KafkaHeaders.TOPIC, "test")
//                .setHeader(KafkaHeaders.KEY, eventKey)
//                .setHeader("type", eventType).build()
//
//        kt.send(msg)
//        return result
//    }
//}