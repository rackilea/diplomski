// must keep a reference to the Binding to prevent premature
// garbage collection:

BooleanBinding allSelected ;

private void bindPanelToPackages(CheckBox pane, CheckBox... packages) {

    // BooleanBinding that is true if and only if all check boxes in packages are selected:
    allSelected = Bindings.createBooleanBinding(() -> 
        // compute value of binding:
        Stream.of(packages).allMatch(CheckBox::isSelected), 
        // array of thing to observe to recompute binding - this gives the array
        // of all the check boxes' selectedProperty()s.
        Stream.of(packages).map(CheckBox::selectedProperty).toArray(Observable[]::new));

    // update pane's selected property if binding defined above changes
    allSelected.addListener((obs, wereAllSelected, areAllNowSelected) -> 
        pane.setSelected(areAllNowSelected));

    // use an action listener to listen for a direct action on pane, and update all checkboxes
    // in packages if this happens:
    pane.setOnAction(e -> 
        Stream.of(packages).forEach(box -> box.setSelected(pane.isSelected())));

}