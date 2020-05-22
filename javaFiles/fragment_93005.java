public void start(Stage stage) {
    Button btn = new Button();
    btn.setText("Button");
    btn.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            System.out.println("Hello World!");
        }
    });

    Scene scene = new Scene(new Group(btn), 300, 250);

    stage.setTitle(VersionInfo.getRuntimeVersion());
    stage.setScene(scene);
    stage.setX(100);
    stage.setY(100);
    stage.show();

    Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
    robot.mouseMove(130, 130);
    robot.mousePress(1);
    robot.mouseRelease(1);
}