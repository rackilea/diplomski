private void initJList() {
    selectedItems.setVisibleRowCount(8);
    selectedItems.setFixedCellWidth(300);
    selectedItems.setFixedCellHeight(40);
    selectedItems.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    selectedItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    //selectedItems = new JList<String>(listModel);
    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
}