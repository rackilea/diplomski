RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

TextView tv = new TextView(r.getContext());
v1.setText("Test n_"+i);
v1.setId(i+1);

params.addRule(RelativeLayout.BELOW, tv.getId()-1);


r.addView(tv);