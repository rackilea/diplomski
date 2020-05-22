private String oldString = "";

@Override
public void start(Stage primaryStage) throws Exception {
    primaryStage.show();

    final Clipboard clipboard = Clipboard.getSystemClipboard();
    EventStreams.ticks(Duration.ofMillis(200)).subscribe(tick -> {
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
    });
}