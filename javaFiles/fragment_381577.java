ObservableList<Text> items = FXCollections.<Text>observableArrayList();

items.add(TextBuilder.create().text("BOLD").style("-fx-font-weight:bold;").build());
// or you can aggregate similar styles in stylesheet and use classname:
items.add(TextBuilder.create().text("BOLD2").styleClass("myClassBoldText").build());
items.add(new Text("regular"));

list.setItems(items);