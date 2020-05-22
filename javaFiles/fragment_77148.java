public void onPreviewNativeEvent(NativePreviewEvent event) {
    NativeEvent nativeEvent = event.getNativeEvent();
    if ("keydown".equals(nativeEvent.getType())) {
        if (nativeEvent.getKeyCode() == KeyCodes.KEY_ESCAPE) {
            Windows.alert("HELLO");
        }
    }
}