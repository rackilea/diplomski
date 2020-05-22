Display display = getWindowManager().getDefaultDisplay();
    DisplayMetrics outMetrics = new DisplayMetrics ();
    display.getMetrics(outMetrics);

    float density  = getResources().getDisplayMetrics().density;        
    float dpWidth  = outMetrics.widthPixels / density;

    RelativeLayout Rl1 = (RelativeLayout) findViewById(R.id.rlv1);
    Rl1.getLayoutParams().height = (int) (dpWidth);

    RelativeLayout Rl2 = (RelativeLayout) findViewById(R.id.rlv2);
    Rl2.getLayoutParams().height = (int) (dpWidth);