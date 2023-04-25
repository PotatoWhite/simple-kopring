package me.potato.simplerestfulapi.controller

import me.potato.simplerestfulapi.model.User
import me.potato.simplerestfulapi.service.UserService
import me.potato.simplerestfulapi.simply.BaseController
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) : BaseController<User, Long>(userService) {

}