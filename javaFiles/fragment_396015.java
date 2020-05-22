private void save(final boolean isChecked, String key) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, isChecked);
        editor.apply();
    }

    private boolean load(String key) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    protected void onPause() {
        super.onPause();
        save(ctv1.isChecked(), "check1");
        save(ctv2.isChecked(), "check2");
        save(ctv3.isChecked(), "check3");



    }

    protected void onResume() {
        super.onResume();
        ctv1.setChecked(load("check1"));
        ctv2.setChecked(load("check2"));
        ctv3.setChecked(load("check3"));

    }