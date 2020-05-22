public abstract class TargetAdapter<T> implements Target<T> {

    @Override
    public void onLoadStarted(Drawable drawable) {}

    @Override
    public void onLoadFailed(Drawable drawable) {}

    @Override
    public void onLoadCleared(Drawable drawable) {}

    @Override
    public void getSize(SizeReadyCallback cb) {}

    @Override
    public void removeCallback(@NonNull SizeReadyCallback cb) {}

    @Override
    public void setRequest(@Nullable Request request) {}

    @Override
    public Request getRequest() {}

    @Override
    public void onResourceReady(@NonNull T resource, @Nullable Transition<? super T> transition) {}
}