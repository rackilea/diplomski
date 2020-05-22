@Override
public void initialize(URL url, ResourceBundle rb) {
    col_ID.setCellValueFactory(new PropertyValueFactory<>("id"));
    col_barcode.setCellValueFactory(new PropertyValueFactory<>("barcode"));
    col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
    col_docType.setCellValueFactory(new PropertyValueFactory<>("docType"));
    col_fileToDelete.setCellValueFactory(new PropertyValueFactory<>("fileToDelete"));
    col_fileToUpload.setCellValueFactory(new PropertyValueFactory<>("fileToUpload"));
    col_requestBY.setCellValueFactory(new PropertyValueFactory<>("requestedBy"));
    col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
}