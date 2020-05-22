enum class Role { ADMIN, USER }

annotation class Secured(val value: Array<Role>)

@Secured([Role.ADMIN, Role.USER])
fun foo() {}