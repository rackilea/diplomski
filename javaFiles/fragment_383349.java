DisplayMetrics displayMetrics = getApplicationContext().getResources().getDisplayMetrics();
float dpWidth = displayMetrics.widthPixels;

RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int)dpWidth, (int)dpWidth);
layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
imageView.setLayoutParams(layoutParams);