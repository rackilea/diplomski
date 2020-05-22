VerticalLayout tab = new VerticalLayout();
tab.setSizeFull();

Table table = new Table();
table.setSizeFull();
tab.addComponent(table);
tab.setExpandRatio(table, 1);

HorizontalLayout buttons = new HorizontalLayout();
buttons.addComponent(new Button());
buttons.addComponent(new Button());
tab.addComponent(buttons);

Tab tabOne = tabs.addTab(tab, "Tab One", null);