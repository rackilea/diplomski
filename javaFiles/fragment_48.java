Display display = new Display();
Listener filter = new Listener() {
  @Override
  public void handleEvent( Event event ) {
    if( /* condition */ ) {
      event.doit = false;
    }
  }
};
display.addFilter( SWT.MouseDown, filter );