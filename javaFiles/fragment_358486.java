Listener paintListener = new Listener() {
  int leftMargin = 40;
  int rightMargin = 10;
  int imageSpacing = 200;
  @Override
  public void handleEvent( Event event ) {
    TableItem item = ( TableItem )event.item;
    Rectangle imageBounds = image.getBounds();
    Point textExtent = event.gc.textExtent( item.getText() );
    switch( event.type ) {
      case SWT.MeasureItem: {
        event.width += leftMargin + imageBounds.width + imageSpacing + textExtent.x + rightMargin;
        event.height = Math.max( event.height, imageBounds.height + 2 );
        event.height = Math.max( event.height, textExtent.y + 2 );
        break;
      }
      case SWT.PaintItem: {
        int x = event.x + leftMargin;
        int imageOffset = ( event.height - imageBounds.height ) / 2;
        event.gc.drawImage( image, x, event.y + imageOffset );
        x += imageSpacing;
        int textOffset = ( event.height - textExtent.y ) / 2;
        event.gc.drawText( item.getText(), x, event.y + textOffset );
        break;
      }
      case SWT.EraseItem: {
        event.detail &= ~SWT.FOREGROUND;
      }
    }
  }
};
table.addListener( SWT.MeasureItem, paintListener );
table.addListener( SWT.PaintItem, paintListener );
table.addListener( SWT.EraseItem, paintListener );