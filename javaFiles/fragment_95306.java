Label nameLabel = new Label();
Person person = new Person();
nameLabel.textProperty().bind(JavaBeanStringPropertyBuilder.create()
    .bean(person)
    .name("name") // name of property to bind to
    .build());