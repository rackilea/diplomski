Listener listener = new Listener() {
  @Override
  public void handleEvent( Event event ) {
    if( event.widget != text || event.widget != fontButton || ... ) {
      save();
    }
  }
};
display.addFilter( SWT.FocusIn, listener );