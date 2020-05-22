public void SaveClickHandler(View view) {

    SharedPreferences prefs = getSharedPreferences(Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = prefs.edit();
    editor.putFloat("height", height); 
    editor.putFloat("weight", weight);
    editor.commit();
}