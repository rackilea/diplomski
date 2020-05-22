//To Save value
    private void saveString(String key, String value){
         SharedPreferences bifrostPrefs = getApplicationContext().getSharedPreferences("bifrostPrefs", android.content.Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = bifrostPrefs.edit();
         editor.putString(key, value);
         editor.commit();
    }