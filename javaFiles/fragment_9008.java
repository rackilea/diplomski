final String popupLocation = "table.popupLocation";
final JTable table = new JXTable(new AncientSwingTeam()) {

    @Override
    public Point getPopupLocation(MouseEvent event) {
        // event may be null if triggered by keyboard, f.i.
        // thanks to @Mad for the heads up!
        ((JComponent) event.getComponent()).putClientProperty(
                popupLocation, event != null ? event.getPoint() : null);
        return super.getPopupLocation(event);
    }

};
JPopupMenu popup = new JPopupMenu();
Action printLocation = new AbstractAction("print cell") {

    @Override
    public void actionPerformed(ActionEvent e) {
       Point p = (Point) table.getClientProperty(popupLocation);
       if (p != null) { // popup triggered by mouse
           int row = table.rowAtPoint(p);
           int column = table.columnAtPoint(p);
           LOG.info("" + table.getValueAt(row, column)); 
       } else { // popup triggered otherwise
           // could choose f.i. by leadRow/ColumnSelection
           ...
       }
    }

};
popup.add(printLocation);
table.setComponentPopupMenu(popup);