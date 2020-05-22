@Override
public void handle(ActionEvent event) {

    Peak thisPeak = new Peak();
    MenuPeak dispPeak = new MenuPeak(thisPeak);
    int row = thisPeak.peakCount();

    // add new nodes
    psMenu.add(dispPeak.name,1,row);
    psMenu.add(dispPeak.retTime,2,row);
    psMenu.add(dispPeak.tol,3,row);
    row++;

    // adjust row of buttons
    GridPane.setRowIndex(save, row);
    GridPane.setRowIndex(cancel, row);
    GridPane.setRowIndex(okay, row);
}