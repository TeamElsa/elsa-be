package io.harry.elsa.repository

import io.harry.elsa.model.MyModel
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MyModelRepository : ReactiveCrudRepository<MyModel, String>