Button b = new Button("Create new console");
b.setOnAction(new EventHandler<ActionEvent>(){
    ... action() {
        new Stage(new Scene(new Group(new TextArea(DeploymentTaskController.actLogTArea.getText()))))).show();
    }
});