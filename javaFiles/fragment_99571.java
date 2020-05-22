public void initialize(URL location, ResourceBundle resources) {
    java.util.Iterator<String> itr = BufferManipulation.Menu.iterator();
    while( itr.hasNext()){
        AddVarMenu.getItems().addAll(new MenuItem(itr.next()));
        }
    java.util.Iterator<MenuItem> Item = AddVarMenu.getItems().iterator();
    while(Item.hasNext()){
        MenuItem MenuFeild = Item.next();
        MenuFeild.setOnAction(e -> AddVarMenu.setText(MenuFeild.getText()));
    }

    System.out.println("Inventory view is now loaded!");
}