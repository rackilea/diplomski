public class ClickAction implements EventHandler<Event>{

    private final TextField textField ;

    public ClickAction(TextField textField) {
        this.textField = textField ;
    }

    @Override
    public void handle(Event event) {
        textField.clear();
    }

}