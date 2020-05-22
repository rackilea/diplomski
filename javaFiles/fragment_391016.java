public void onStop() {
    saveArray();
    super.onStop();
}

public ArrayList<String> getArray() {
    SharedPreferences sp = this.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);

    //NOTE: if shared preference is null, the method return empty Hashset and not null
    Set<String> set = sp.getStringSet("list", new HashSet<String>());

    return new ArrayList<String>(set);
}