public RightPane extends FlowPane {
    private TextField field;
    private BooleanProperty myConnector;

    public LeftPane(myConnector) {
        this.field = new TextField();
        this.myConnector = myConnector;
        ChangeListener<Boolean> listener = (observable, oldValue, newValue) -> {
            // update this UI part
            this.field.setEditable(newValue);
        };
        myConnector.addListener(listener);
        listener.changed(null, null, myConnector.get());
    }

    an event on action {
        this.myConnector.set(false);
    } 
}