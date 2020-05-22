@ApplicationPath("/api")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        register(GZIPWriterInterceptor.class);
    }
}