LinearLayout layout = (LinearLayout) findViewById(R.id.ad_layout);

LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

layout.addView(adView, params);