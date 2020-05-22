class MyFrame<T extends SuperClass> {
    private final DefaultListModel list; 

    public MyFrame(final List<T> elementsToDisplay) {
        this.list = createListModel(elementsToDisplay);
    }
}