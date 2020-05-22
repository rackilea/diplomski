List<EventHandler<ActionEvent>> handlers = Arrays.asList(
                                                    this::aButton,
                                                    this::bButton,
                                                    this::cButton
    );

@FXML
public void onEnter(ActionEvent event){
    int index = testBox.getSelectionModel().getSelectedIndex();
    if (index >= 0) {
         handlers.get(index).handle(event);
    }
}