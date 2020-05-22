final int viewNum = i;
txtViewName.setOnClickListener(new OnClickListener() {   
     @Override
     public void onClick(View view) {
         Toast.makeText(MainActivity.this, "You clicked on view "+viewNum, Toast.LENGTH_SHORT).show();
     }
});