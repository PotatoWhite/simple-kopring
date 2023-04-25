package me.potato.simplerestfulapi.repository

import me.potato.simplerestfulapi.model.User
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

interface UserRepository : ReactiveCrudRepository<User, Long> {
}