CheckBox cb1 = new CheckBox("1");
    CheckBox cb2 = new CheckBox("2");

    BooleanProperty isCb1Selected = cb1.selectedProperty();
    BooleanProperty isCb2Selected = cb2.selectedProperty();

    Textfield foo = new TextField().visibleProperty().bind(isCb1Selected.and(isCb2Selected));