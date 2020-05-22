final View child = constraintLayout.getChildAt(i);
Object tag = child.getTag(R.id.tagId);
if (tag != null) {
    if (child instanceof TextView) {
        TextView tv = (TextView) child;
        tv.setGravity(Gravity.START);
    }
} else {}