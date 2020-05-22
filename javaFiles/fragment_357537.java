private GridPane currentTable;

@FXML
private void Loadinfo(ActionEvent event) throws IOException, ParseException {

    String co=(String) coachBox.getSelectionModel().getSelectedItem();

    getbusinfo(getBusID(co));

    coachLbl.setText(co);
    SubRouteLbl.setText(source+"-"+destination);
    BusNameLbl.setText(busname);

    //Adding Gridpane to the anchorpane of Bus Seat structure
    int row=Integer.parseInt(totalrows);
    int col=Integer.parseInt(totalcolumns);
    System.out.println("row: "+row);
    System.out.println("col: "+col);

    GridPane newTable = drawBus(row,col);

    if (currentTable == null) {
        BusStructure.getChildren().add(newTable);
    } else {
        // replace table
        BusStructure.getChildren().set(BusStructure.getChildren().indexOf(currentTable), newTable);
    }

    AnchorPane.setRightAnchor(newTable, 0.0);
    AnchorPane.setTopAnchor(newTable, 0.0);
    AnchorPane.setBottomAnchor(newTable, 0.0);
    AnchorPane.setLeftAnchor(newTable, 0.0);

    // save reference to table to determine which node to replace
    currentTable = newTable;
}