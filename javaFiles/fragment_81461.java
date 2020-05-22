private String oldString = "";

@Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.show();

    final Clipboard clipboard = Clipboard.getSystemClipboard();
    Timeline repeatTask = new Timeline(new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if (clipboard.hasString()) {
                String newString = clipboard.getString();
                if(!oldString.equals(newString)) {
                    System.out.printf("String changed in clipboard: " + newString);
                    oldString = newString;
                }
                else {
                    System.out.println("String not changed.");
                }
            }
        }
    }));
    repeatTask.setCycleCount(Timeline.INDEFINITE);
    repeatTask.play();
}