Event.addNativePreviewHandler(new NativePreviewHandler() {
    public void onPreviewNativeEvent(NativePreviewEvent event) {
        if (Event.as(event).getTypeInt() == Event.ONCLICK &&
            DOM.isOrHasChild(DOM.getElementById("buttonId"), Element.as(event.getEventTarget()))) {
            //Button was clicked.and notifys all elements clicks here
        }
    }
}