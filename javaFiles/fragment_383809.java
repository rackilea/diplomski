private void saveCurrentTIme() {
        SharedPreferences sharedpreferences = getSharedPreferences("myAppPref",
            Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putLong("GameTime", System.currentTimeMillis());
        editor.commit();
}