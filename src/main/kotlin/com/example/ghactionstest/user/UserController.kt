package com.example.ghactionstest.user

import jakarta.websocket.server.PathParam
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/api/v1/users")
class UserController(val userService: UserService) {

  @GetMapping("/save/{name}/{age}")
  fun saveUser(@PathVariable("name") name: String, @PathVariable("age") age: Int): ResponseEntity<UUID> {
    println("recieved request to save user = $name, age = $age")
    val uuid = userService.saveUser(name, age)
    return ResponseEntity.ok(uuid)
  }

  @GetMapping("/{uuid}")
  fun getUser(@PathVariable("uuid") uuid: UUID): ResponseEntity<User> {
    println("receiveid request to get user for $uuid")
    return ResponseEntity.ok(userService.getUser(uuid))
  }

}

data class UserRequest(val name: String, val age: Int)
