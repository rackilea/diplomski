@Override
protected Control createDialogArea( Composite parent ) {
  Control startPoint = super.createDialogArea( parent );
  Control firstControl = null;
  if( startPoint instanceof Composite ) {
    Composite composite = ( Composite )startPoint;
    Control[] children = composite.getChildren();
    for( Control control : children ) {
      if( ( control.getStyle() & SWT.NO_FOCUS ) == 0 ) {
        firstControl = control;
        break;
      }
    }
  }
  return parent;
}