@ReactMethod
    public void startActivityForResult(int requestCode, String deeplink, ReadableMap data, Promise promise) {
        Activity activity = getReactApplicationContext().getCurrentActivity();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(deeplink));
        intent.putExtras(Arguments.toBundle(data));
        activity.startActivityForResult(intent, requestCode);
        mPromises.put(requestCode, promise);
    }