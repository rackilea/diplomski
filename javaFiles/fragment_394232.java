sourceViewer.getTextWidget().addTraverseListener( new TraverseListener() {
  @Override
  public void keyTraversed( TraverseEvent event ) {
    if( event.detail == SWT.TRAVERSE_TAB_NEXT ) {
      if( sourceViewer.canDoOperation( ITextOperationTarget.SHIFT_RIGHT ) ) {
        sourceViewer.doOperation( ITextOperationTarget.SHIFT_RIGHT );
      }
      event.doit = false;
    } else if( event.detail == SWT.TRAVERSE_TAB_PREVIOUS ) {
      if( sourceViewer.canDoOperation( ITextOperationTarget.SHIFT_LEFT ) ) {
        sourceViewer.doOperation( ITextOperationTarget.SHIFT_LEFT );
      }
      event.doit = false;
    }
  }
} );