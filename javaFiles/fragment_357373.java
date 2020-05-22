@Component
class RootMutationResolver(
   private val userRepository: UserRepository
) : GraphQLMutationResolver {

    fun createUser(user: UserInput): User = userRepository.save(User(
            id = UUID.randomUUID().toString(),
            email = user.email,
            nick = user.nick
    ))
}