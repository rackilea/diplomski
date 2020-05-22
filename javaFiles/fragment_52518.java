Callback<TableColumn<Person, String>, TableCell<Person, String>> cellFactory = new Callback<TableColumn<Person, String>, TableCell<Person, String>>() {
  @Override
  public TableCell<Person, String> call(TableColumn<Person, String> col) { 
    TableCell<Person, String> cell = new EditingCell();
    cell.addEventFilter(...); // same code as you have in the question
    return cell ;
  }
});