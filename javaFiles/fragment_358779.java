sendData.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         if (v.getId() == R.id.button) {
             mCallback.sendInformations(userInput.getText().toString());
         }
     }
 });