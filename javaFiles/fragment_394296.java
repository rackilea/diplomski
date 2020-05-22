protected void afterHideToolTip(Event event) {
    super.afterHideToolTip(event);

    // Clear the restored value else this could be a source of a leak
    setData(VIEWER_CELL_KEY, null);
    if (event != null && event.widget != viewer.getControl()) {
        viewer.getControl().setFocus();
    }
}