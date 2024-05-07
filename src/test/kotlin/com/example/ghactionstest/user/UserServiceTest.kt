package com.example.ghactionstest.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import java.util.UUID

class UserServiceTest {

  @Test
  fun should_getUser_when_userExists() {
    //given
    val uuid = UUID.randomUUID()
    val userRepository = mock(UserRepository::class.java)
    `when`(userRepository.getUser(uuid)).thenReturn(getUser(uuid, "name", 23))
    val userService = UserService(userRepository)

    //when
    val user = userService.getUser(uuid)

    //then
    assertThat(user?.name).isEqualTo("name")
    assertThat(user?.age).isEqualTo(23)
  }

  private fun getUser(uuid: UUID, name: String, age: Int): User {
    return User(uuid, name, age)
  }

}
