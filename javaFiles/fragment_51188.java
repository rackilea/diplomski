@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent

@Component(dependencies = [NetworkComponent::class], modules = [ApiModule::class])
interface ApiComponent {
    fun inject(target: GithubRetriever)        
}