//get the MiniDrawer
MiniDrawer miniDrawer = result.getMiniDrawer();
//build it and get the view
View miniDrawerView = miniDrawer.build(this);
//define the width (You could also do it via the LayoutParams
miniDrawerView.setMinimumWidth((int) UIUtils.convertDpToPixel(144, this));
//add the MiniDrawer to your view hirachy
findViewById(R.id.frame_container)).addView(miniDrawerView, 0);