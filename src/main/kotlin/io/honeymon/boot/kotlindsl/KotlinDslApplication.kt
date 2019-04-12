package io.honeymon.boot.kotlindsl

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDslApplication

fun main(args: Array<String>) {
    runApplication<KotlinDslApplication>(*args)
}
