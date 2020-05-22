new ChangeListener<Worker.State>() {
    private final Bridge bridge = new Bridge();

    @Override
    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
        if (newState == Worker.State.SUCCEEDED) {

            // ...

            jso.setMember("java", bridge);
        }
    }