tableViewPriority.setRowFactory(tv -> new TableRow<SomeClass>() {

    @Override
    protected void updateItem(SomeClass item, boolean empty) {
        super.updateItem(item, empty); 
        if (item!=null && "Low".equals(item.getPriority())) {
            if (! getStyleClass().contains("tableViewGreen")) {
                getStyleClass().add("tableViewGreen");
            }
        } else {
            getStyleClass().remove("tableViewGreen");
        }
    }
});