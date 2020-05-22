final VerticalLayout layout = new VerticalLayout();
    layout.setMargin(true);
    layout.setSpacing(true);
    layout.setStyleName("flow_visible");
    final HorizontalLayout navBarLayout = new HorizontalLayout();
    final VerticalLayout contentLayout = new VerticalLayout();
    final VerticalLayout spacingLayout = new VerticalLayout();
    final HorizontalLayout footerLayout = new HorizontalLayout();
    String dummyText = "TDummy text";
    navBarLayout.addComponent(new Label("Navigation bar"));
    navBarLayout.setStyleName("navbar");
    navBarLayout.setWidth("100%");

    contentLayout.setSizeFull();
    contentLayout.setSpacing(true);
    Button addButton = new Button("Add more content",
            (Button.ClickListener) clickEvent -> {
                contentLayout.addComponent(new Label(dummyText),
                        contentLayout.getComponentCount() - 2);
            });
    contentLayout.addComponent(addButton);
    for (int i = 0; i < 6; i++) {
        contentLayout.addComponent(new Label(dummyText));
    }
    spacingLayout.setSizeFull();
    contentLayout.addComponent(spacingLayout);
    contentLayout.setExpandRatio(spacingLayout, 1f);

    footerLayout.addComponent(new Label("Footer"));
    footerLayout.setStyleName("footer");
    footerLayout.setWidth("100%");
    contentLayout.addComponent(footerLayout);

    layout.addComponent(navBarLayout);
    layout.addComponent(contentLayout);
    layout.setSizeFull();
    layout.setExpandRatio(contentLayout, 1f);