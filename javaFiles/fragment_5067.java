Label nombreLabel = new Label();
NodoJugadores nj = new NodoJugadores();
nombreLabel.textProperty().bind(new JavaBeanStringPropertyBuilder()
    .bean(nj)
    .name("nombre")
    .build());