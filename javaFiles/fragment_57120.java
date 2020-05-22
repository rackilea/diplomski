public static void main( String[] args ) {
  Display display = new Display();
  Shell shell = new Shell( display );
  shell.setLayout( new RowLayout( SWT.VERTICAL ) );
  ExpandBar bar = new ExpandBar( shell, SWT.NONE );
  Composite composite = new Composite( bar, SWT.NONE );
  composite.setBackground( display.getSystemColor( SWT.COLOR_YELLOW ) );
  ExpandItem item = new ExpandItem( bar, SWT.NONE, 0 );
  item.setText( "First item" );
  item.setHeight( 200 );
  item.setControl( composite );
  Label label = new Label( shell, SWT.NONE );
  label.setText( "text" );

  bar.addExpandListener( new ExpandListener() {
    @Override
    public void itemExpanded( ExpandEvent event ) {
      relayout();
    }

    @Override
    public void itemCollapsed( ExpandEvent event ) {
      relayout();
    }

    private void relayout() {
      display.asyncExec( () -> {
        bar.pack();
        shell.layout();
      });
    }
  } );

  shell.setSize( 400, 350 );
  shell.open();
  while( !shell.isDisposed() ) {
    if( !display.readAndDispatch() ) {
      display.sleep();
    }
  }
  display.dispose();
}