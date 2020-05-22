@Override public void start(Stage stage) {

    // existing code, but remove this:
    // Scene scene  = new Scene(new Group());

    // and replace this

    // ((Group) scene.getRoot()).getChildren().add(bc);
    // ((Group) scene.getRoot()).getChildren().add(chart);

    // with this:

    HBox root = new HBox();    
    root.getChildren().add(bc);
    root.getChildren().add(chart);

    Scene scene  = new Scene(root);
    stage.setScene(scene);
    stage.show();
}