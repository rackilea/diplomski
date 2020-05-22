public abstract class PlatformCallback<T> {

    public void callback(final Result result, final T t) {
        Gdx.app.postRunnable(new Runnable() {
            @Override
            public void run() {
                doCallback(result, t);
            }
        });
    }

    protected abstract void doCallback(Result result, T t);
}