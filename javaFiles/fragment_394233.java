textViewer.prependVerifyKeyListener( new VerifyKeyListener() {
  @Override
  public void verifyKey( VerifyEvent verifyEvent ) {
    if( verifyEvent.keyCode == SWT.TAB && sourceViewer.getSelectedRange().y > 0 ) {
      verifyEvent.doit = false;
    }
  }
} );