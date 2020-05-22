@Module
public StateTypeHandlersModule {

    // @Provides @IntoMap               // Syntax for dagger >= 2.9
    @Provides(type = Provides.Type.MAP) // Syntax for dagger <= 2.8
    @StateTypeKey(StateType.DEFAULT)
    StateHandler provideDefaultStateHandler(DefaultStateHandler handler) {
        return handler;
    }

    // @Provides @IntoMap               // Syntax for dagger >= 2.9
    @Provides(type = Provides.Type.MAP) // Syntax for dagger <= 2.8
    @StateTypeKey(StateType.OTHER_STATE)
    StateHandler provideOtherStateHandler(OtherStateHandler handler) {
        return handler;
    }

}