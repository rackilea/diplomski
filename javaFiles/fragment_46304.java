//  which will make your table view dynamic 
 ObservableList<ObservableList> csvData = FXCollections.observableArrayList(); 

 for(List<String> dataList : data) {
     ObservableList<String> row = FXCollections.observableArrayList();
    for( String rowData : dataList) {
      row.add(rowData); 
  }
   cvsData.add(row); // add each row to cvsData
}

table1.setItems(cvsData); // finally add data to tableview