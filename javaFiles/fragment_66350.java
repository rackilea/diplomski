WebEngine webEngine = new WebEngine();
ChangeListener<State> initialListener = new ChangeListener<State>() {
    @Override
    public void changed(ObservableValue<? extends State> obs, State oldState, State newState) {
        if (newState == State.SUCCEEDED) {
            webEngine.getLoadWorker().stateProperty().removeListener(this);
            List<String> allCarsOnTheWebsite = webEngine.getDocument()... ;
            loadPagesConsecutively(allCarsOnTheWebsite, webEngine);
        }
    }
};
webEngine.getLoadWorker().addListener(initialListener);      
webEngine.loadPage("http://www.something.com/list-of-cars");

// ...

private void loadPagesConsecutively(List<String> pages, WebEngine webEngine) {
    LinkedList<String> pageStack = new LinkedList<>(pages);
    ChangeListener<State> nextPageListener = new ChangeListener<State>() {
        @Override
        public void changed(ObservableValue<? extends State> obs, State oldState, State newState) {
            if (newState == State.SUCCEEDED ) {
                // process current page data
                // ...
                if (pageStack.isEmpty()) {
                    webEngine.getLoadWorker().stateProperty().removeListener(this);
                } else {
                    // load next page:
                    webEngine.load(pageStack.pop());
                }
            }               
        }
    };
    webEngine.getLoadWorker().stateProperty().addListener(nextPageListener);

    // load first page (assumes pages is not empty):
    webEngine.load(pageStack.pop());
}