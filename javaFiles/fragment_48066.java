Intent intent = getIntent();
String buttonText = intent.getStringExtra("button_text");

//activity could also be started without providing the extra
if(buttonText != null){
    Button button = new Button(this);
    button.setText(buttonText);
    LinearLayout ll = (LinearLayout)findViewById(R.id.main_screen);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams
      (LinearLayout.LayoutParams.WRAP_CONTENT, 
      LinearLayout.LayoutParams.WRAP_CONTENT);
    ll.addView(button, layoutParams);
}