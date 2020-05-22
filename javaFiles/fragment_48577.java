public static final int FinallwidthDp  = 320 ;
     public static final int widthJustify  = 223 ;

     DisplayMetrics metrics = new DisplayMetrics();
     getWindowManager().getDefaultDisplay().getMetrics(metrics);
     int widthPixels = metrics.widthPixels;

     float scaleFactor = metrics.density;
     float widthDp = widthPixels / scaleFactor;

     TextView tv = (TextView) findViewById(R.id.textView1);
     ViewGroup.MarginLayoutParams lp1 = (ViewGroup.MarginLayoutParams) tv.getLayoutParams();

     tv.setText(text);
     TextJustify.run(tv,widthDp / FinallwidthDp * widthJustify , tv.getPaddingLeft(),tv.getPaddingRight() , lp1.leftMargin, lp1.rightMargin);