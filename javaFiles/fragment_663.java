public LeftPane extends FlowPane {
    private Button button;
    private BooleanProperty myConnector;

    public LeftPane(myConnector) {
        this.button = new Button();
        this.myConnector = myConnector;
        ChangeListener<Boolean> listener = (observable, oldValue, newValue) -> {
            this.button.setDisable(newValue);
        };
        myConnector.addListener(listener);
        listener.changed(null, null, myConnector.get());
    }

    an event on action {
        this.myConnector.set(false);
    } 
}