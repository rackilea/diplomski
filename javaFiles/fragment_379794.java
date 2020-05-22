TableColumn<Appointment, LocalDateTime> appTableViewStartColumn = ...

...

final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
appTableViewStartColumn.setCellFactory(col -> new TableCell<Appointment, LocalDateTime>() {
    @Override
    protected void updateItem(LocalDateTime item, boolean empty) {
        super.updateItem(item, empty);
        setText(item == null ? "" : formatter.format(item));
    }
});