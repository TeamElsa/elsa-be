package io.harry.elsa.config

import com.github.jasync.r2dbc.mysql.JasyncConnectionFactory
import com.github.jasync.sql.db.mysql.pool.MySQLConnectionFactory
import com.github.jasync.sql.db.mysql.util.URLParser
import io.harry.elsa.properties.SpringR2DbcProperties
import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Profile("dev")
@Configuration
@ConfigurationPropertiesScan("io.harry.elsa.properties")
@EnableR2dbcRepositories
class R2DbcConfiguration(val springR2DbcProperties: SpringR2DbcProperties) {
  @Bean
  fun connectionFactory(): ConnectionFactory {
    val url = springR2DbcProperties.url
    val username = springR2DbcProperties.username
    val password = springR2DbcProperties.password

    val databaseUrl = "mysql://${username}:${password}@${url}"

    return JasyncConnectionFactory(MySQLConnectionFactory(URLParser.parseOrDie(databaseUrl)))
  }
}