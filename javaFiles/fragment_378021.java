class Item {
  private String name ;
  public String getName() {
    return name ;
  }
  public void setName(String name) {
    this.name = name ;
  }
}

TableColumn<Item, String> nameCol = new TableColumn<>("Name");
nameCol.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue.getName()));