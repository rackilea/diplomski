public class GuiController implements CliController {

    @Override
    public void parseDialogue(Dialogue dialogue) {
        // some preliminary work (still on background thread here) if necessary...
        Platform.runLater(() -> {
            // code that updates UI here...
        });
    }
}