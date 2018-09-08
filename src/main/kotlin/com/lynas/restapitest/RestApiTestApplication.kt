package com.lynas.restapitest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RestApiTestApplication

fun main(args: Array<String>) {
    runApplication<RestApiTestApplication>(*args)
}

@RestController
class HomeController {

    @GetMapping("/")
    fun hello() = "hello"


}