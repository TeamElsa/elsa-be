package io.harry.elsa.repository

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest
import reactor.test.StepVerifier

@DataR2dbcTest
class MyModelRepositoryTest(@Autowired private val myModelRepository: MyModelRepository) {
  @Test
  internal fun hello() {
    StepVerifier.create(myModelRepository.findAll())
      .expectNextMatches { it.name == "Jinho" }
      .expectNextMatches { it.name == "Sunho" }
      .verifyComplete()
  }
}