package me.potato.simplerestfulapi.simply

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

abstract class BaseController<T : BaseEntity<ID>, ID>(private val baseService: BaseService<T, ID>) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(entity: T): T = baseService.create(entity).awaitFirst()

    @GetMapping
    fun getAll(): Flow<T> = baseService.getAll().asFlow()

    @GetMapping("/{id}")
    suspend fun getById(@PathVariable id: ID): T = baseService.getById(id).awaitFirst()

    @PutMapping("/{id}")
    suspend fun update(@PathVariable id: ID, entity: T): T = baseService.update(id, entity).awaitFirst()

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun deleteById(@PathVariable id: ID): Void = baseService.deleteById(id).awaitFirst()
}