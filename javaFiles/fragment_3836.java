tblItems.addPopupMenuListener( new PopupMenuListener() {
    @Override
    public void popupMenuWillBecomeVisible( PopupMenuEvent evt ) {
        // set checkbox
        if( rightClickRow >= 0 ) {
            mdlItems.setValueAt( true, rightClickRow, model.COL_CHECK );
        }
    }
    @Override
    public void popupMenuCanceled( PopupMenuEvent evt ) {
        // return checkbox to prior value
        if( rightClickRow >= 0 ) {
            mdlItems.setValueAt( rightClickValue, rightClickRow, model.COL_CHECK );
        }
    }
} );