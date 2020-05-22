private SharedPreferences getMySharedPreferences() {
    return getSharedPreferences(MainActivity.class.getSimpleName(),
            Context.MODE_PRIVATE);
}

private void storeData(String data) {
    final SharedPreferences prefs = getMySharedPreferences();
    SharedPreferences.Editor editor = prefs.edit();
    editor.putString("data", data);    
    editor.commit();
}

private String retrieveData() {
    final SharedPreferences prefs = getMySharedPreferences();
    return prefs.getString("data", "");    
}