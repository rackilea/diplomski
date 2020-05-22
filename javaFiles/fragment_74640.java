VerticalLayout vlMain = new VerticalLayout();
vlMain.setSizeFull();

HorizontalLayout hlFooter = new HorizontalLayout();
hlFooter.setHeight("50px"); // if you want you can define a height.
hlFooter.addComponent(new Label("Test1")); // adding a simple component. You might want to set alignment for that component

vlMain.addComponent(mainComponent);
vlMain.setExpandRatio(mainComponent, 1.0f); // "give" the main component the maximum available space
vlMain.addComponent(hlFooter);