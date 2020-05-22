public HomepageView() {
    this.addAttachListener(e -> {
        getUI().getPage().setTitle(IStringConstants.HOMEPAGE_LABEL);
    });
    VerticalLayout layout = new VerticalLayout();
    layout.setSizeFull();
    setCompositionRoot(layout);

    // show something
    layout.addComponent(new Label("Hello World!"));
}