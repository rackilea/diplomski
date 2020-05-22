private void closebackuptaskandshowmaintask(Event event) throws Exception {
    // Decalaration of Variables
    final Stage stage, stage1;
    FXMLLoader pane;
    Parent taskselectwindow;
    String eventstring;

    // Execution Block
    eventstring = event.getEventType().toString();
    if ("ACTION".equals(eventstring)) {
        stage = (Stage) BackupTaskExitButton.getScene().getWindow();
        stage.close();
    } else if ("WINDOW_CLOSE_REQUEST".equals(eventstring)) {
        event.consume();
        stage = (Stage) event.getSource();
        stage.close();            
    }
    pane = new FXMLLoader(getClass().getResource("FXMLBlahBLahUI.fxml"));
    taskselectwindow = (Parent) pane.load();
    stage1 = new Stage();
    stage1.setScene(new Scene(taskselectwindow));
    stage1.setTitle("BlahBLahUI");
    stage1.show();
}