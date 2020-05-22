enum class Role { ADMIN, USER }

annotation class Secured(vararg val value: Role)

@Secured(Role.ADMIN, Role.USER)
fun foo() {}