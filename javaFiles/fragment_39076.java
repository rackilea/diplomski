parent.setLayout( new GridLayout( 1, false ) );
...
Table table = new Table( parent, SWT.NONE );
GridData gridData = new GridData();
gridData.heightHint = table.getHeaderHeight() + ( 3 * table.getItemHeight() );
table.setLayoutData( gridData );