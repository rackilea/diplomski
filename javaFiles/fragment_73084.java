int clientWidth = ...
int clientHeight = table.getItemHeight * numberOfItems;
if( table.getLinesVisible() && numberOfItems > 0 ) {
  clientHeight += table.getGridLineWidth() * ( numberOfItems - 1 );
}
Rectangle bounds = table.computeTrim( 0, 0, clientWidth, clientHeight );

GridData gridData = new GridData( SWT.DEFAULT, clientHeight );