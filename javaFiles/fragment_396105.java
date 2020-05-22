private void addExceptionHandler(ReactApplicationContext reactContext) {
    reactContext.setNativeModuleCallExceptionHandler(new NativeModuleCallExceptionHandler() {
        @Override
        public void onHandleException(Exception e) {
            if (e instanceof JavascriptException) {
                Crashlytics.log(e.getMessage());
            } else {
                Crashlytics.logException(e);
            }
        }
    });
}