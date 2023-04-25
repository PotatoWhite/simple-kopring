package me.potato.simplerestfulapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleRestfulApiApplication

fun main(args: Array<String>) {
    runApplication<SimpleRestfulApiApplication>(*args)
}
