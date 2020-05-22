int[] attrs = new int[]{R.attr.selectableItemBackground};
TypedArray typedArray = this.obtainStyledAttributes(attrs);
int selectableItemBackground = typedArray.getResourceId(0, 0);
typedArray.recycle();

cardView.setForeground(this.getDrawable(selectableItemBackground));
cardView.setClickable(true);