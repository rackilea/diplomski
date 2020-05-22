public boolean saveArray() {
    SharedPreferences sp = this.getSharedPreferences(SHARED_PREFS_NAME, Activity.MODE_PRIVATE);
    SharedPreferences.Editor mEdit1 = sp.edit();
    Set<String> set = new HashSet<String>();
    set.addAll(SavedCustomPasswords);
    mEdit1.putStringSet("list", set);
    return mEdit1.commit();
}