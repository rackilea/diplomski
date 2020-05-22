Label label = new Label( parent, SWT.NONE );
label.setText( "&Name" );
label.addListener( SWT.Traverse, new Listener() {
  @Override
  public void handleEvent( Event event ) {
    if( event.detail == SWT.TRAVERSE_MNEMONIC ) {
      event.doit = false;
      otherControl.setFocus();
    }
  }
} );