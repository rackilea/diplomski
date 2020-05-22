Use this code inside onclick 

ImageView imageview = new ImageView(MainActivity.this);
     RelativeLayout relativelayout = (RelativeLayout)findViewById(R.id.relativeLayout);
     LinearLayout.LayoutParams params = new LinearLayout
     .LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

     // Add image path from drawable folder.
     imageview.setImageResource(R.drawable.demo_new_image);
     imageview.setLayoutParams(params); 
     relativelayout.addView(imageview);