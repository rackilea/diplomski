@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityModule::class, BroadCastReceiversModule::class,...]
)
interface AppComponent {
    fun inject(pocketTreasureApplication: MyApplication)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}