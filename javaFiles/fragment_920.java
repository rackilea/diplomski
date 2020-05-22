TextField field = new TextField();
TextFormatter fieldFormatter = new TextFormatter(
      TextFormatter.IDENTITY_STRING_CONVERTER, "initial");
field.setTextFormatter(fieldFormatter);
fieldFormatter.valueProperty().addListener((s, ov, nv) -> {
    // do stuff that needs to be done on commit
} );