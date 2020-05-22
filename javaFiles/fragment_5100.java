public void onClick(ClickEvent event) {
    Button button = (Button) event.getSource();
    Integer rowIndex = buttonRowMap.get(button);
    TextBox tb = (TextBox) g.getWiget(rowIndex, 2);
    ...
}