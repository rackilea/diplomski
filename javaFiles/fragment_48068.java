SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
Set<String> buttonSet = prefs.getStringSet("saved_buttons", null);
if(buttonSet != null){
    LinearLayout ll = (LinearLayout)findViewById(R.id.main_screen);
    for(String buttonText : buttonSet){
        Button button = new Button(this);
        button.setText(buttonText);    
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
          (LinearLayout.LayoutParams.WRAP_CONTENT, 
          LinearLayout.LayoutParams.WRAP_CONTENT);
        ll.addView(button, layoutParams);
    }
}