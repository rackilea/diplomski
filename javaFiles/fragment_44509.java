private final ArrayList<View> mMenuItems = Lists.newArrayList();
private boolean mIsConnected;

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Add a your MenuItem
    menu.add("Connected").setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    // Adjust the text color based on the connection
    final TextView connected = !mMenuItems.isEmpty() ? (TextView) mMenuItems.get(0) : null;
    if (connected != null) {
        connected.setTextColor(mIsConnected ? Color.GREEN : Color.RED);
    } else {
        // Find the "Connected" MenuItem View
        final View decor = getWindow().getDecorView();
        decor.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                mIsConnected = true;
                // Remove the previously installed OnGlobalLayoutListener
                decor.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                // Traverse the decor hierarchy to locate the MenuItem
                decor.findViewsWithText(mMenuItems, "Connected",
                        View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);
                // Invalidate the options menu to display the new text color
                invalidateOptionsMenu();
            }

        });

    }
    return true;
}