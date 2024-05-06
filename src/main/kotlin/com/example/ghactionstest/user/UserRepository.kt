package com.example.ghactionstest.user

import java.util.*

interface UserRepository {

  fun saveUser(user: User)

  fun getUser(uuid: UUID): User?

  fun getAll(): List<User>
}
