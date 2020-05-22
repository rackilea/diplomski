private void getLastInputButtonText(){
    SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
    String lastInput = pref.getString("YourKeyNameHere");

    if(!lastInput.isEmpty()){
        input_btn.setText(lastInput);
    }
    //Else do what ever you need to do
}