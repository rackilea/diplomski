LinearLayout ll = new LinearLayout(this);  
  ll.setOrientation(LinearLayout.VERTICAL); //orientation 
  ll.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,  LayoutParams.FILL_PARENT));  //setting width and height
  ll.setGravity(Gravity.CENTER);  //setting the gravity
  ll.addView(label);  //adding a view..
  ll.addView(pic);  
  setContentView(ll);  //applying the layout to the activity