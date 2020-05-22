public void pressMe(View view) {
    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.main);
    TextView tv = new TextView(MainActivity.this);
    tv.setGravity(Gravity.CENTER);
    tv.setTextSize(25);
    tv.setPadding(0, 5, 0, 5);
    tv.setText("TextView " + linearLayout.getChildCount());
    linearLayout.addView(tv);
}