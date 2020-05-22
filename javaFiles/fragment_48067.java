@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    //you specified the request code before, when launching the second activity
    if(requestCode == ADD_USER_REQUEST){
        if(resultCode == Activity.RESULT_OK){
            String buttonText = data.getStringExtra("button_text");
            if(buttonText != null){
                Button button = new Button(this);
                button.setText(buttonText);
                LinearLayout ll = (LinearLayout)findViewById(R.id.main_screen);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
                  (LinearLayout.LayoutParams.WRAP_CONTENT, 
                  LinearLayout.LayoutParams.WRAP_CONTENT);
                ll.addView(button, layoutParams);

                //here comes the part that saves the button strings persistently
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Set<String> buttonSet = prefs.getStringSet("saved_buttons",null);
                if(buttonSet == null){
                    buttonSet = new HashSet<String>();
                }
                buttonSet.add(buttonText);
                prefs.edit.putStringSet("saved_buttons", buttonSet).commit();
            }

        }
    }