int count = parentLinearLayout.getChildCount();

 for(int i=0; i<count; i++) {
     LinearLayout linearLayout = (LinearLayout)parentLinearLayout.getChildAt(i);
     EditText editText = (EditText)linearLayout.getChildAt(0);
     String result = editText.getText().toString();
     //You can result get data from edit text.
 }