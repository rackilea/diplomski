@FXML
void done(ActionEvent event) {
    int index = eventList.getSelectionModel().getSelectedIndex();
    LocalEvent localEvent = list.get(index);
    localEvent.setCompleted(true);
    list.set(index, localEvent);
}