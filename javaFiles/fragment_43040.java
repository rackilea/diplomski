@Override
public void run() {

    final String tmpVar = ...;

    // ... (Some code)
    // ... (Some code)
    // ... (Some code)

    Platform.runLater(new Runnable() {
        @Override public void run() {

        // access tmpVar here:

        for (int i=0; i<2000;i++)
            {
             MyMainClass.leftPaneTextArea.appendText("Goodi!\n");
            }

        }
    });

    // ... (Some code)
    // ... (Some code)
    // ... (Some code)
}