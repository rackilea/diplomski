private boolean isSomethingTrue(String param) {
    class MyCallback implements Callback<Boolean> {
        boolean result = false;
        @Override
        public void onSuccess(Boolean hasAlerts) {
            result = hasAlerts;
        }
    }
    final MyCallback callback = new MyCallback();
    myService.findBoolean(param, callback);
    return callback.result;
}