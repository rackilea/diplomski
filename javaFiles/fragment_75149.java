try {
    // Get the intent passed through activities
    Intent thumb_check = getIntent();
    // Get the string in the extra
    String intent_Thumb = thumb_check.getStringExtra("trueThumbnail", "checked_thumb");

    // Get the shared preferences
    SharedPreferences prefs = this.getSharedPreferences(
                          "ch4an.ytheloader", Context.MODE_PRIVATE);

    //To read from preferences
        String pref_Thumb = prefs("trueThumbnail", "checked_thumb");

    // preform what ever you want

} catch (Throwable e) {
    Toast.makeText(MainActivity.this, "Null checkBox", Toast.LENGTH_SHORT).show();
         e.printStackTrace();
}