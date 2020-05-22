public class GameFX {

    private final BorderPane rootPane ; // or any other kind of pane, or  Group...

    public GameFX() {

        rootPane = new BorderPane();

        // build UI, register event handlers, etc etc

    }

    public Pane getRootPane() {
        return rootPane ;
    }

    // other methods you may need to access, etc...

}