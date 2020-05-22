private static void showPopup(MouseEvent me) throws FontFormatException,
    IOException {

// is this event a popup trigger?
if (pm.isPopupTrigger(me)) {
    Point p = me.getPoint();
    row = table.rowAtPoint(p);
    final int col = table.columnAtPoint(p);
    // if we've clicked on a row in the second column
    if (row != -1 && col == 1) {
        final ImageIcon progress = new ImageIcon("images/progress.png");
        one.setIcon(progress);
        final ImageIcon ok = new ImageIcon("images/ok.png");
        two.setIcon(ok);

        one.setText("In progress " + row + ".");
        two.setText("Solved " + row + ".");
        pm.show(table, p.x, p.y);

    } 

}
}