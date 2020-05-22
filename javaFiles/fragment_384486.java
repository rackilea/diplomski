@FXML
private void numChange(ActionEvent event) {
    Node node = (Node) event.getSource() ;
    String data = (String) node.getUserData();
    int value = Integer.parseInt(data);

    // ...
}