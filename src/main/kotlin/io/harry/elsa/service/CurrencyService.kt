package io.harry.elsa.service

import io.harry.elsa.model.Currency
import io.harry.elsa.model.Currency.CurrencyTypes
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CurrencyService {
  fun getCurrency(): Mono<Currency> {
    return Mono.just(Currency("id",11.1, 1, CurrencyTypes.USD))
  }
}