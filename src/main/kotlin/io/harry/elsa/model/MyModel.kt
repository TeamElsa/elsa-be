package io.harry.elsa.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("my_models")
data class MyModel(
  @Id
  val id: String,
  val name: String,
  val age: Int
)