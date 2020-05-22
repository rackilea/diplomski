// Bind the label to display a size-aware notification
label.textProperty().bind(new StringBinding() {
    { bind(listSize); }

    @Override
    protected String computeValue() {
        return "The list contains " + listSize.get() + ((items.size() != 1) ? " items!" : " item!");
    }

});