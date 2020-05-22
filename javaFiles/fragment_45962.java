SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
    int show = sp.getInt("firstlaunch", 0);
    if(show == 0) {
        Toast.makeText(getApplicationContext(), "WELCOME", Toast.LENGTH_LONG).show();
        sp.edit().putInt("firstlaunch", 1).apply();
    }