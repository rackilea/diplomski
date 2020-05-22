@Module
internal abstract class AppActivityModule {

    @Module
    internal interface WelcomeActivityModule {
      // The component that @ContributesAndroidInjector generates will bind
      // your WelcomeActivity, but not your Activity. So just connect the two,
      // and suddenly you'll have access via injections of Activity.
      @Binds fun bindWelcomeActivity(activity: WelcomeActivity) : Activity
    }

    @ContributesAndroidInjector(
        modules = [ActivityModule::class, WelcomeActivityModule::class])
    abstract fun contributeWelcomeActivityInjector(): WelcomeActivity
}