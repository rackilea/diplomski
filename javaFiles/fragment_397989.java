public boolean saveThePreferences(Context c){

    Gson gson = new Gson();

    String theJson = gson.toJson(this);
    c.getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
            .edit()
            .putString(PREF_TEXT,theJson)
            .commit();

    return true;
}