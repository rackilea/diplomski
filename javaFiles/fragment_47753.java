Template template = new Template();
ImageCell imageCell = new ImageCell( template );
imageCell.setBindingIndex( 0 ); // bind to image from column 0
imageCell.setTop( 4 ).setLeft( 4 ).setWidth( 48 ).setHeight( 48 );

table.setData( RWT.ROW_TEMPLATE, template );