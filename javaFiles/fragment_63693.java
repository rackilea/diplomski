// Abstract class so you don't have to provide an instance
@Module
abstract class ActivityModule {

    // No need for ActivityScope: You're always binding to the same Activity, so
    // there's no reason to have Dagger save your Context instance in a Provider.
    @Binds @ActivityContext
    abstract fun providesContext(activity: Activity): Context

    // This doesn't *have* to be in a companion object, but that way
    // Android can do a static dispatch instead of a virtual method dispatch.
    // If you don't need that, just skip the constructor arguments and make these
    // normal methods and you'll be good to go.
    @Module
    companion object {
        @JvmStatic @Provides @ActivityContext
        fun providesLayoutInflater(activity: Activity): LayoutInflater = 
            activity.layoutInflater

        @JvmStatic @Provides @ActivityContext
        fun providesResources(activity: Activity): Resources = activity.resources
    }
}