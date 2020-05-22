Event.addNativePreviewHandler(new Event.NativePreviewHandler() {
    @Override
    public void onPreviewNativeEvent(Event.NativePreviewEvent event) {
        nativeEvent nativeEvent = event.getNativeEvent();
        // Do all sort of cool stuff with nativeEvent
    }
});