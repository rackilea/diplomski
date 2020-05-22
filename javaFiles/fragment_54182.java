@FXML
    void delAction(ActionEvent event) {
            fnlData.remove(index);
            finalTable.getSelectionModel().clearSelection();
        finalTable.getItems().clear();
        finalTable.getItems().addAll(fnlData);
    }