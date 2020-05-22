if (linearLayout.getChildAt(i) instanceof EditText){
    EditText editText = (EditText) linearLayout.getChildAt(i);
    editText.setText("EditText " + i);
} else if (linearLayout.getChildAt(i) instanceof TextView){
     TextView someTetView = (TextView) linearLayout.getChildAt(i);
     someTetView.setText("TV " + i);
}else {
   //do nothing
}