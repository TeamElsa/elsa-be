package io.harry.elsa.controller

import io.harry.elsa.model.Currency
import io.harry.elsa.service.CurrencyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class CurrencyController(private val currencyService: CurrencyService) {
  @GetMapping("/currency")
  fun getCurrency(): Mono<Currency> {
    return currencyService.getCurrency()
  }

}