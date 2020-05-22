private static class ListWriteDoubleProperty extends SimpleDoubleProperty {
    private final ObservableList<Double> list;
    private final int index;

    public ListWriteDoubleProperty(ObservableList<Double> list, int index) {
        super(list.get(index));
        this.list = list;
        this.index = index;
    }

    @Override
    protected void invalidated() {
        list.set(index, get());
    }

}