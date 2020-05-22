@Override
public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);

    Configuration configuration = getResources().getConfiguration();//returns the app screen size.
    int screenHeightDp = configuration.screenHeightDp-56;// 56 is the max height of the android toolbar. 
    float density = this.getResources().getDisplayMetrics().density; 


    screenHeightDp = (int)(screenHeightDp*density);//changes the dp to pixel


    Button perWordHistory = findViewById(R.id.perWordHistory);
    int heightOfButton = perWordHistory.getHeight()*2; // as I have two buttons
    screenHeightDp = screenHeightDp - heightOfButton;

    LinearLayout linearLayout = findViewById(R.id.layoutContainingRecycleView);
    linearLayout.setMinimumHeight(screenHeightDp);
}