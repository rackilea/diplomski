Table table = new Table();

BeanItemContainer<MyBean> itemContainer = new BeanItemContainer<MyBean>(MyBean.class);
table.setContainerDataSource(itemContainer);

table.addItem(new MyBean("A", 1));
table.addItem(new MyBean("B", 2));

table.addGeneratedColumn("Action", new ColumnGenerator() { // or instead of "Action" you can add ""
    @Override
    public Object generateCell(final Table source, final Object itemId, Object columnId) {
        Button btn = new Button("Delete");
        btn.addClickListener(new ClickListener() {
            @Override
            public void buttonClick(ClickEvent event) {
                source.removeItem(itemId);
            }
        });
        return btn;
    }
});

table.setVisibleColumns(new Object[]{"designation", "value", "Action"}); // if you added "" instead of "Action" replace it by ""