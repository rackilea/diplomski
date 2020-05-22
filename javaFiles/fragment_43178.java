tree.addListener( SWT.KeyDown, new Listener() {
  @Override
  public void handleEvent( Event event ) {
    if( event.keyCode == SWT.ARROW_DOWN && ( event.stateMask & SWT.MOD3 ) != 0 ) {
      event.doit = false;
    }
  }
} );