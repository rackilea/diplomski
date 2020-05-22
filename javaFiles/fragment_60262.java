@Override
public void enter(ViewChangeListener.ViewChangeEvent event) {
    getUI().getPage().setTitle("This is a title");
    VerticalLayout layout = new VerticalLayout();
    layout.setSizeFull();
    setCompositionRoot(layout);
    layout.addComponent(new Label("Hello World!"));
}