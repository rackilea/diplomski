Table table = new Table( parent, SWT.NONE );
table.setData( RWT.MARKUP_ENABLED, Boolean.TRUE );
table.setData( RWT.CUSTOM_ITEM_HEIGHT, Integer.valueOf( 80 ) );

TableItem item = new TableItem( table, SWT.NONE );
String imageUrl = RWT.getRequest().getContextPath() + "/" + registerImage( "foo.png" );
item.setText( "<img src='" + imageUrl + "' width='10' height='10' style='padding-right:5px'/>" );