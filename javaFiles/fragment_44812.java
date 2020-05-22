Event.addNativePreviewHandler(new NativePreviewHandler() {
  @Override
  public void onPreviewNativeEvent(NativePreviewEvent event) {
    if (event.getTypeInt() == Event.ONKEYDOWN) {
      NativeEvent ne = event.getNativeEvent();

      if (ne.getCtrlKey() && ne.getKeyCode() == 'Z') {
        event.cancel();
        // Handle undo
      } else if (ne.getCtrlKey() && ne.getKeyCode() == 'Y') {
        event.cancel();
        // Handle redo
      }
    }
  }
});