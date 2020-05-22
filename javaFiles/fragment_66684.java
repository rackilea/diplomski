LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    int adlayout = 12345;   //if you need id of layout somewhere else  
                           //View.generateViewId();Can be used if minSDK= 17 
    layout.setId(adlayout);

    android.view.ViewGroup.LayoutParams params = layout.getLayoutParams();
    params.height = 48;
    params.width = LayoutParams.MATCH_PARENT;
    //Below code is used if you need height in dp.
    //int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, <HEIGHT>, getResources().getDisplayMetrics());

    ir.adad.AdView adView = new ir.adad.AdView(this);
    int adViewId = 123456;//Should not be dublicate.
    adView.setId(adViewId);
    android.view.ViewGroup.LayoutParams paramView = adView.getLayoutParams();
    paramView.height = LayoutParams.WRAP_CONTENT;
    paramView.width = LayoutParams.WRAP_CONTENT;

    layout.addView(adView)