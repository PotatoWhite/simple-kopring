package me.potato.simplerestfulapi.simply

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

abstract class BaseService<T : BaseEntity<ID>, ID>(private val baseRepository: ReactiveCrudRepository<T, ID>) {

    fun create(entity: T): Mono<T> = baseRepository.save(entity)
    fun getAll(): Flux<T> = baseRepository.findAll()
    fun getById(id: ID): Mono<T> = baseRepository.findById(id)
    fun update(id: ID, entity: T): Mono<T> {
        return baseRepository
                .findById(id)
                .map { found -> entity.apply { this.id = found.id } }
                .flatMap { baseRepository.save(it) }
    }

    fun deleteById(id: ID): Mono<Void> = baseRepository.deleteById(id)
}