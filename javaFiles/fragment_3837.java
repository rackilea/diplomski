tblItems.addMouseListener( new MouseAdapter() {
    @Override
    public void mouseClicked( MouseEvent evt ) {
        rightClickRow = tblItems.rowAtPoint( evt.getPoint() );
        rightClickValue = mdlItems.getValueAt(rightClickRow, model.COL_CHECK) == Boolean.TRUE;
    }
}