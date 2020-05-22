@FXML
private Accordion accord;
@FXML
private TitledPane pane1,pane2;

//codes in controller.intialize()
...
    pane1.setText("TitledPane A");
    pane2.setText("TitledPane B");
    accord.setExpandedPane(pane1);