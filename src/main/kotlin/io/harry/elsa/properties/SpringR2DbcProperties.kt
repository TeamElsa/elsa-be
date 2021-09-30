package io.harry.elsa.properties

import mu.KotlinLogging
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import javax.annotation.PostConstruct


@ConstructorBinding
@ConfigurationProperties(prefix = "spring.r2dbc")
class SpringR2DbcProperties(val url: String, val username: String, val password: String) {
  private val logger = KotlinLogging.logger(this::class.qualifiedName!!)

  @PostConstruct
  private fun postConstruct() {
    logger.debug { this }
  }

}