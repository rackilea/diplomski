HorizontalLayout hl = new HorizontalLayout();
TextField tF= new TextField("Test");
h1.addComponent(tF);
Button btn= new Button("Do Something");
h1.addComponent(btn);
h1.setComponentAlignment(tF, Alignment.MIDDLE_CENTER);
h1.setComponentAlignment(btn, Alignment.MIDDLE_CENTER);