@Override
public void onResponse(ResponseBody responseBody) {
    String data = responseBody.string();
    Log.d("RAW_DATA", data);
    sharedPreferences.edit().putString(myKey, data);
}