A solution: 

FlexTable myTable = new FlexTable();
myTable.addClickHandler(new ClickHandler() {
public void onClick(ClickEvent event) {
    Cell cell = myTable.getCellForEvent(event);
    int receiverRowIndex = cell.getRowIndex();
}
});