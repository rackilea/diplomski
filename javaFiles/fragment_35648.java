addButton.setOnAction((event)->{
    data.add(new Book(String.valueOf(newBookIndex++),"test"));

    VirtualFlow vf=(VirtualFlow)lv.lookup(".virtual-flow");
    BookCell cell = (BookCell)vf.getCell(lv.getItems().size()-1);
    cell.runAnimation();
});