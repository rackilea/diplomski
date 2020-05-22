public void setupMenuKeyListenerRecursive(View v) {
    if (v != null) {
        try {
            ViewGroup viewGroup = (ViewGroup)v;
            int childCount = viewGroup.getChildCount();
            for (int index = 0; index < childCount; index++) {
                View child = viewGroup.getChildAt(index);
                setupMenuKeyListenerRecursive(child);
            }
        } catch (Exception e) {
        }
        v.setOnKeyListener(mMenuKeyListener);
    }
}