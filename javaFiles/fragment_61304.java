public static void SaveInPreference(Context mContext, String key, String objString) {
    SharedPreferences.Editor editor = mContext.getSharedPreferences(mContext.getString(R.string.app_name),
            Context.MODE_PRIVATE).edit();
    editor.putString(key, objString);
    editor.commit();
}

public static String getPrefString(Context mContext, final String key, final String defaultStr) {
    SharedPreferences pref = mContext.getSharedPreferences(mContext.getString(R.string.app_name),
            Context.MODE_PRIVATE);
    return pref.getString(key, defaultStr);
}