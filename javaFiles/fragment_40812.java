table.addMouseListener( new MouseAdapter()
{
    public void mouseReleased(MouseEvent e)
    {
        if (e.isPopupTrigger())
        {
            JTable source = (JTable)e.getSource();
            int row = source.rowAtPoint( e.getPoint() );
            int column = source.columnAtPoint( e.getPoint() );

            if (! source.isRowSelected(row))
                source.changeSelection(row, column, false, false);

            popup.show(e.getComponent(), e.getX(), e.getY());
        }
    }
});