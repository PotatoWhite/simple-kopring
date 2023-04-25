package me.potato.simplerestfulapi.service

import me.potato.simplerestfulapi.model.User
import me.potato.simplerestfulapi.repository.UserRepository
import me.potato.simplerestfulapi.simply.BaseService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Service
@Validated
class UserService(private val userRepository: UserRepository) : BaseService<User, Long>(userRepository) {

}