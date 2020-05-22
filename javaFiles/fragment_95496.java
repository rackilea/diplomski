@ApplicationPath("rest")
public class MyApplication extends ResourceConfig {
    public MyApplication() {
        register(new HeaderParamResolverBinder());
        packages("your.packages");
    }
}