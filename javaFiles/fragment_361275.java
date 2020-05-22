View bottomBorder = new View(CONTEXT);
bottomBorder.setBackgroundColor(Color.GRAY);
RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, 1);
params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

relativeLayout.addView(bottomBorder, params);