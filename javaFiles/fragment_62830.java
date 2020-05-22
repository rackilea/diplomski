public class Result<T> {
    private T value;
    public void set(T value) { this.value = value; }
    public T get() { return value; }
}

private boolean isSomethingTrue(String param) {
    final Result<Boolean> result = new Result<Boolean>();
    myService.findBoolean(param,new Callback<Boolean>(
        @Override
        public void onSuccess(Boolean hasAlerts) {
            result.set(hasAlerts);
        }
    });
    return result.get();
}