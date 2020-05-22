@Override
public boolean onInterceptTouchEvent(MotionEvent arg) {
    if (arg.getPointerCount() < 2) {
        if (!this.isDrawerOpen(this.listView)) {
            // The drawer is locked closed. The user may not open it.
            this.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }
    } else {
        // The drawer is unlocked.
        this.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    return super.onInterceptTouchEvent(arg);
}