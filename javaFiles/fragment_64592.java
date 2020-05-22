@Override
protected void handleControlPropertyChanged(String p) {
    if ("SHOWING".equals(p)) {
        if (getSkinnable().isShowing()) {
            show();
        } else {
            super.handleControlPropertyChanged(p);
        }
    } else {
        super.handleControlPropertyChanged(p);
    }
}


private void show() {
    if (!popup.isShowing()) {
        popup.show(getSkinnable(), getSkinnable().getPopupSide(), 100, 100);
    }
}