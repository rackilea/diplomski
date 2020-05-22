private void setInputButtonText(String value){
    input_btn.setText(value);

    //Save input text in SharedPreferences
    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
    SharedPreferences.Editor edit = pref.edit();
    edit.putString("YourKeyNameHere", value);
    boolean success = edit.commit();
    // you can do something with success if you need

}