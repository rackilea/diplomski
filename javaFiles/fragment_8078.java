abstract class ResultAdapter<T> implements ResultCallback<T> {
    @Override
    public void onResult(T t) {
    }

    @Override
    public void onDelete() {
    }

    @Override
    public void onError(String msg) {
    }
}