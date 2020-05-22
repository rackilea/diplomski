Button btn = new Button (shell, SWT.PUSH);
btn.setText ("test");
btn.addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {

       // Here the x co-ordinate of the Point represents the column
       // index and y co-ordinate stands for the row index.
       // i.e, x = indexOf(focusColumn); and y = indexOf(focusItem);
       Point focusCell = grid.getFocusCell();
       grid.selectCell(focusCell);

        // eg., selects the intersecting cell of the first column(index = 0)
        // in the second row item(rowindex = 1).
        Point pt = new Point(0, 1);
        grid.selectCell(pt);
}
});