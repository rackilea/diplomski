childName.addTextChangedListener(new TextWatcher() {

      public void afterTextChanged(Editable s) {

         String question= //....get the question;
         String sWithName = 
         question.replace("xxx",yourEditText.getText().toString())
         yourTextView.setText(sWithName);

      }

      public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

      public void onTextChanged(CharSequence s, int start, int before, int count) {}
   });
}