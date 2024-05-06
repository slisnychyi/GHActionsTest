package com.example.ghactionstest.user

import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class StubUserRepository : UserRepository {

  private val users = mutableMapOf<UUID, User>()

  override fun saveUser(user: User) {
    users.put(user.uuid, user)
  }

  override fun getUser(uuid: UUID): User? {
    return users[uuid]
  }

  override fun getAll(): List<User> {
    return users.values.toList()
  }


}
