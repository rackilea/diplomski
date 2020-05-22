TableColumn<Task, LocalDate> deadlineColumn = new TableColumn<>("Deadline");
deadlineColumn.setCellValueFactory( cellData -> cellData.getValue().deadlineProperty() ); // or similar...
PseudoClass overdue = PseudoClass.getPseudoClass("overdue");
deadlineColumn.setCellFactory(col -> new TableCell<Task, LocalDate>() {
    @Override
    public void updateItem(LocalDate deadline, boolean empty) {
        super.updateItem(deadline, empty) ;
        if (empty) {
            pseudoClassStateChanged(overdue, false);
            setText(null);
        } else {
            pseudoClassStateChanged(overdue, LocalDate.now().isAfter(deadline));
            setText(deadline.toString());
        }
    }
});