public static void main( String[] args ) {
  Listener listener = new Listener() {
    @Override
    public void handleEvent( Event event ) {
      System.out.println( event );
    }
  };
  Display display = new Display();
  Shell shell = new Shell( display );
  shell.setText( "Shell" );
  shell.addListener( SWT.MouseDown, listener );
  Button button = new Button( shell, SWT.PUSH );
  button.setText( "Button" );
  button.setBounds( 100, 100, 400, 100 );
  button.addListener( SWT.MouseDown, listener );
  shell.setSize( 600, 600 );
  shell.open();
  while( !shell.isDisposed() ) {
    if( !display.readAndDispatch() )
      display.sleep();
  }
  display.dispose();
}