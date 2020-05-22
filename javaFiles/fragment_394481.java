Button test = new Button(this);
test.setText("test");
test.setBackgroundResource(R.color.blue);
test.setLayoutParams (new 
LinearLayout.LayoutParams(60,ViewGroup.LayoutParams.FILL_PARENT));
mLinearLayout.addView(test); //this will show your button on layout