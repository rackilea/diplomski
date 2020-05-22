// ----->> app
@Component(modules = [AppModule::class])
interface AppComponent {
    fun app(): App
}

@Module
class AppModule {

    @Provides
    fun provideParser(): ArgParser = object : ArgParser {} // just bind a dummy implementation

    @Provides
    fun provideApi(argParser: ArgParser): AbstractApi {
        return DaggerApiComponent.factory().create(argParser).api()
    }
}