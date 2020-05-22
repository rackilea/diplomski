SharedPreferences prefs = PreferenceManager
            .getDefaultSharedPreferences(YourActivity.this);
SharedPreferences.Editor editor = prefs.edit();

editor.putBoolean("monitorStatus", monitorToggle.isChecked());
editor.commit();