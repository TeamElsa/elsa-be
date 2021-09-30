package io.harry.elsa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ElsaApplication

fun main(args: Array<String>) {
  runApplication<ElsaApplication>(*args)
}

