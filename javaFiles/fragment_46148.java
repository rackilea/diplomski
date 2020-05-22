View view = findViewById(R.id.view_child);
PercentRelativeLayout.LayoutParams params = (PercentRelativeLayout.LayoutParams) view.getLayoutParams();
// This will currently return null, if it was not constructed from XML.
PercentLayoutHelper.PercentLayoutInfo info = params.getPercentLayoutInfo();
info.heightPercent = 0.60f;
view.requestLayout();