@Module
public class NetworkModule {
    @Provides
    @Singleton
    public static INetworkLayer provideNetworkLayer(OkHttpClient okHttpClient) {
        return new ProductionNetworkLayer(okHttpClient);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new /*create okHttpClient*/;
    }
}