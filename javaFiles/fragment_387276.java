final ObservableList<Node> children = pane.getChildren();

InvalidationListener listener = new InvalidationListener() {

    private int size = children.size();

    @Override
    public void invalidated(Observable o) {
        int newSize = children.size();
        if (size != newSize) { // prevent triggering if the size did not change
            size = newSize;
            // TODO: add some logic
        }
    }

};
children.addListener(listener);