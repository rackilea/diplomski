RelativeLayout rlVP = new RelativeLayout(getActivity());
RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
rlVP.setLayoutParams(params2);

TextView emptyView = createEmptyView("Blabla test");
rlVP.addView(emptyView);
lv.setEmptyView(emptyView);
rlVP.addView(lv);