del.setOnClickListener(new View.OnClickListener() {
   @Override
   public void onClick(View v) {
      String text = et1.getText().toString();
      if(!text.isEmpty()) et1.setText(text.substring(0, text.length() - 1));
   }
});