// ----->> google
@Component(modules = [ApiModules::class])
interface ApiComponent {
    // has a provision method for our API
    fun api(): AbstractApi

    @Component.Factory
    interface Factory {
        // factory method to bind additional args that we need to supply
        fun create(@BindsInstance parser: ArgParser): ApiComponent
    }
}

@Module
internal interface ApiModules {
    @Binds
    fun bindApi(googleApi: GoogleApi): AbstractApi

}