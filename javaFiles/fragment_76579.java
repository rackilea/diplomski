@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    LinearLayout rootLayout = new LinearLayout(getApplicationContext());
    rootLayout.setOrientation(LinearLayout.VERTICAL);

    //Convert DIPs to Pixels
    int dp = 50;
    int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());

    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(px * 4, px);

    for (int i = 1; i < 6; i++) {
        Button button = new Button(getApplicationContext());
        button.setLayoutParams(layoutParams);
        button.setText("Button " + i);
        rootLayout.addView(button);
    }

    setContentView(rootLayout);
}