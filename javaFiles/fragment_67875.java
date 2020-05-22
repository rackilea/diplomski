@Singleton
public class ProductionNetworkLayer {
    private OkHttpClient okHttpClient;

    @Inject
    public ProductionNetworkLayer(OkHttpClient okHttpClient) {
         this.okHttpClient = okHttpClient;
    }
}

@Module
public abstract class NetworkModule {
    @Binds
    public abstract INetworkLayer provideNetworkLayer(ProductionNetworkLayer productionNetworkLayer);
    // same as `public INetworkLayer prov(ProductionNetworkLayer prod) { return prod; }`

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new /*create okHttpClient*/;
    }
}