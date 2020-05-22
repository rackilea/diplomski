public void setUpListpopupWindow() {
    listPopupWindow = new ListPopupWindow(BluetoothActivity.this);
    listPopupWindow.setAnchorView(btnOpenMenu);
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    listPopupWindow.setWidth(metrics.widthPixels); //sets width as per the screen.
    listPopupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
    listPopupWindow.setModal(true);

    View filterLayout = getLayoutInflater().inflate(R.layout.your_awesome_custom_layout, null);

    listPopupWindow.setPromptView(filterLayout);
}