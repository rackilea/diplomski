@Override
public void run() {

    String tmpVar;

    // ... (Some code)
    // ... (Some code)
    // ... (Some code)

        Platform.runLater(new Updater(tmpVar));

    // ... (Some code)
    // ... (Some code)
    // ... (Some code)
}

// ...

public static class Updater implements Runnable {

    private final String var ;

    public Updater(String var) {
        this.var = var ;
    }



    @Override 
    public void run() {

        // Access var here

        for (int i=0; i<2000;i++){
            MyMainClass.leftPaneTextArea.appendText("Goodi!\n");
        }

    }
}