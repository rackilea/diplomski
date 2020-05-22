//prod Injector
@Module
public class NetworkModule {
    @Provides
    @Singleton
    public static INetworkLayer provideNetworkLayer() {
        return new ProductionNetworkLayer();
    }
}

//mock Injector
@Module
public class NetworkModule {
    @Provides
    @Singleton
    public static INetworkLayer provideNetworkLayer() {
        return new MockNetworkLayer();
    }
}