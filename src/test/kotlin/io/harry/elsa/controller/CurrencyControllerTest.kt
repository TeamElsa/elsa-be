package io.harry.elsa.controller

import io.harry.elsa.model.Currency
import io.harry.elsa.model.Currency.CurrencyTypes
import io.harry.elsa.service.CurrencyService
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Mono

@WebFluxTest(CurrencyController::class)
class CurrencyControllerTest @Autowired constructor(
  private val webClient: WebTestClient,
  @MockBean private val currencyService: CurrencyService
) {
  @Test
  internal fun `calls get currency`() {
    val testCurrency = Currency("someId", 1183.67, 1, CurrencyTypes.USD)
    given(currencyService.getCurrency()).willReturn(
      Mono.just(testCurrency)
    )

    this.webClient.get().uri("/currency").exchange().expectStatus().isOk().expectBody().json(
      """
        {
          "id": "someId",
          "won": 1183.67,
          "unit": 1,
          "currency": "USD"
        }
      """.trimIndent()
    )
  }
}