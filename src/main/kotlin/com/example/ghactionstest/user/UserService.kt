package com.example.ghactionstest.user

import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(val userRepository: UserRepository) {

  fun saveUser(name: String, age: Int): UUID {
    val uuid = UUID.randomUUID()
    val user = User(uuid, name, age)
    userRepository.saveUser(user)
    return uuid
  }

  fun getUser(uuid: UUID): User? {
    return userRepository.getUser(uuid)
  }


  fun getAll(): List<User> {
    return userRepository.getAll()
  }

}
