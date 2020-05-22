@UiHandler("focusPanel")
void onFocusPanelKeyPress(KeyPressEvent event) {
    if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
        submit();
    }
}