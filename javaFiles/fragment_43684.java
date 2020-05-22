public void save(Context context) {
        String assignment = _gson.toJson(this);
        SharedPreferences prefs = context.getSharedPreferences(prefs_file, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = prefs.edit();
        edit.clear();
        edit.putString(this._assignmentName, assignment);
        edit.commit();
    }