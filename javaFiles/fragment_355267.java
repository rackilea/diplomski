Browser browser = new Browser( shell, SWT.NONE );
browser.setText( "<html><head></head><body></body></html>" );
browser.addProgressListener( new ProgressAdapter() {
  public void completed( ProgressEvent event ) {
    Object font = browser.evaluate( "return document.defaultView.getComputedStyle( document.body, null ).getPropertyValue('font-family');" );
  }
} );