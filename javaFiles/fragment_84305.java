@Override
public void start(Stage stage) throws Exception {

    Parent root = new AfterburnerView().getView();

    Model model = Injector.instantiateModelOrService(Model.class);
    model.setText("This is a test");

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
}