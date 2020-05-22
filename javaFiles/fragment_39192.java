firstNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
lastNameColumn.setCellValueFactory(new PropertyValueFactory<Person, String("name"));

firstNameColumn.setCellFactory(new Callback<TableColumn<Person,Name>,TableCell<Person,Name>>()
{
    @Override
    public TableCell<Person, Name> call(TableColumn<Person,Name> p)
    {
        final TableCell<Person,Name> cell = new TableCell<Person,Name>()
        {
            @Override
            public void updateItem(final Name item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty)
                {
                    this.setText(""); 
                }
                else
                {
                    this.setText(item.getFirstName());
                }
            }
        };
        return cell;
    }
});