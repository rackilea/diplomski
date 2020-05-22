// save index and top position
int index = mList.getFirstVisiblePosition();
View v = mList.getChildAt(0);
int top = (v == null) ? 0 : (v.getTop() - mList.getPaddingTop());

// ...

// restore index and position
mList.setSelectionFromTop(index, top);