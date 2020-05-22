field1.addTextChangedListener(new TextWatcher() {

   @Override    
   public void onTextChanged(CharSequence s, int start,
     int before, int count) {

         /* Add the Handler Call here */
         handler.postDelayed(runnable, 1000);

     }
});