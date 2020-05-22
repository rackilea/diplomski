RelativeLayout layout = (RelativeLayout) findViewById(R.id.relLayout);

RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

layout.addView(adView, params);