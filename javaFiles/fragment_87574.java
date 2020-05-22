@Override
protected void init(VaadinRequest request) {
    Window mainWindow = new Window("So9 Application");
    VerticalLayout layout = new VerticalLayout();
    Panel panel = new Panel("Panel");
    VerticalLayout panelLayout = new VerticalLayout();
    OptionGroup optionGroup = new OptionGroup();
    panel.setHeight("200px");
    panel.setWidth("200px");
    for (int i = 0; i < 10; i++) {
        optionGroup.addItem(i);
    }
    panelLayout.addComponent(optionGroup);
    panel.setContent(panelLayout);
    layout.addComponent(panel);
    mainWindow.addComponent(layout);
    setMainWindow(mainWindow);
}