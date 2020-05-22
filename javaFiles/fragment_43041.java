@Override
public void run() {

    String tmpVar ;

    // ... (Some code)
    // ... (Some code)
    // ... (Some code)

    final String varCopy = tmpVar ;

    Platform.runLater(new Runnable() {
        @Override public void run() {

        // access varCopy here:

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