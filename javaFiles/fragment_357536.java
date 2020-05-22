public static GridPane drawBus(int rows, int col){
    GridPane table = new GridPane();
    table.setHgap(4);
    table.setVgap(4);
    table.setAlignment(Pos.CENTER);

    for(int i=0; i<rows; i++){

        for(int j=0;j<col; j++) {
            Button seat=new Button();
            seat.setAlignment(Pos.CENTER);
            seat.setPrefSize(80, 31);
            seat.setText(i+","+j);
            seat.setStyle("-fx-background-color: MediumSeaGreen");

            //add them to the GridPane
            table.add(seat, j, i); //  (child, columnIndex, rowIndex)
        }
    }
    return table;
}