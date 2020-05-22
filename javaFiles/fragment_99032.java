@Override
protected Void doInBackground(Void... arg0) {
    ProviderHTTP sh = new ProviderHTTP();
    String jsonStr = sh.makeServiceCall(url);
    Log.e(TAG, "Response from url: " + jsonStr);

    if (jsonStr != null) {
        try {
             JSONObject jsonObj = new JSONObject(jsonStr);
             String content = jsonObj.getString("content");
             Looper.prepare();
             toast.setText(content);
             tost.show();
    }
    return null;
}