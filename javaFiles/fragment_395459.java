@Singleton
@Component(modules={NetModule.class})
public interface NetComponent {
    /** Exposes OkHttpClient. Used by components depending on NetComponent. */
    OkHttpClient getOkHttpClient();
}