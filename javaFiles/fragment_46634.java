PseudoClass low = PseudoClass.getPseudoClass("low");

tableViewPriority.setRowFactory(tv -> new TableRow<SomeClass>() {

    @Override
    protected void updateItem(SomeClass item, boolean empty) {
        super.updateItem(item, empty); 
        pseudoClassStateChanged(low, item!=null && "Low".equals(item.getPriority()));
    }
});