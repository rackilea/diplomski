btnYes.setOnClickListener(new View.OnClickListener() { 
   @Override public void onClick(View view) { 
       dialog.dismiss(); 
       button.getValue().onClick(view); 
   }
});