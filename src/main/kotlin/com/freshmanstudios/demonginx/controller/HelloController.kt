package com.freshmanstudios.demonginx.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import java.time.Duration
import kotlin.random.Random

@Controller
class HelloController(
    @Value("\${instance.id:unknown}")
    private val instanceId: String
) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(HelloController::class.java)
    }

    @GetMapping("/hello")
    fun sayHello(): ResponseEntity<String> {
        LOGGER.info("Hello there from instance: $instanceId")
        return ResponseEntity.ok("Hello there from instance: $instanceId")
    }

    @GetMapping("/helloWithDelay")
    fun sayHelloDelayed(): ResponseEntity<String> {
//        sayHello()
        val sleepTime = Random.nextLong(from = 1, until = 3)
        Thread.sleep(Duration.ofSeconds(sleepTime))
        LOGGER.info("Goodbye from instance: $instanceId. I slept for $sleepTime seconds.")
        return ResponseEntity.ok("Hello there from instance: $instanceId")
    }


}