@Override
public void start(Stage stage) throws Exception {
    ...
    stage.setScene(scene);
    stage.show();

    com.sun.glass.ui.Window.getWindows().forEach(System.out::println);
}