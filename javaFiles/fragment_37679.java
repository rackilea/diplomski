table.setRowFactory(tableView -> {
    final TableRow<Person> row = new TableRow<>();

    row.hoverProperty().addListener((observable) -> {
        final Person person = row.getItem();

        if (row.isHover() && person != null) {
            label.setText("Address Book: " 
                + person.getFirstName() + " " 
                + person.getLastName()
            );
        } else {
            label.setText("Address Book");
        }
    });

    return row;
});