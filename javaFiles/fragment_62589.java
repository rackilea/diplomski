popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
    @Override
    public void onDismiss() {
        rotateFabBackward();
        showPopupWindow = false;
        // end may TODO anything else                   
    }
});