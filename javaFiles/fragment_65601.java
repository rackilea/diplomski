Event.addNativePreviewHandler(new NativePreviewHandler() { 
  @Override 
  public void onPreviewNativeEvent(NativePreviewEvent event) {
    if (event.getNativeEvent().getType().equals("click")) { 
      // reset your timer
    } 
  }
});