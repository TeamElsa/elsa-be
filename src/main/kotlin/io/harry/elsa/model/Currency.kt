package io.harry.elsa.model

import org.springframework.data.annotation.Id

data class Currency(
  @Id val id: String,
  val won: Double,
  val unit: Int,
  val currency: CurrencyTypes
) {
  enum class CurrencyTypes {
    USD,
  }
}