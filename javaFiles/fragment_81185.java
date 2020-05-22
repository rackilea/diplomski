myTable.addGeneratedColumn("address", new Table.ColumnGenerator() {
    public Component generateCell(Table table, Object itemId, Object columnId) {
        BeanItem<MyBean> item = myContainer.getItem(itemId);
        Property<String> address = item.getItemProperty("address");
        TextField tf = new TextField();
        tf.setPropertyDataSource(address);
        return tf;
    }
}