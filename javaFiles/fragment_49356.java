public class MainThreadExecutor implements Executor {
    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void execute(@Nonnull Runnable runnable) {
        handler.post(runnable);
    }
}