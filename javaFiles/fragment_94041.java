EditText editText = (EditText)findViewById(R.id.editTextBox);

Button btn = (Button)findViewById(R.id.checkBtn);
btn.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View v) {
        if(editText.getText().toString().equalsIgnoreCase("helloworld")){
          //Launch activity with new view
       }

     }

});