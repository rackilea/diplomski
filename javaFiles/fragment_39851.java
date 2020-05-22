View actionBarView = getLayoutInflater().inflate(R.layout.my_action_bar, null)
ImageView actionItem = (ImageView) actionBarView.findViewById(R.id.myImageViewIcon);
actionItem.setOnLongClickListener(new OnLongClickListener(){
   @Override
   public boolean onLongClick(View v){
      // Show toast with custom text
   }
});
actionItem.setOnClickListener(new OnClickListener(){
   @Override
   public boolean onClick(View v){
      // Handle regular click
   }
});
getSupportActionBar().setCustomView(actionBarView);