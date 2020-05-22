button.disableProperty().bind(
    textField1.textProperty().isEmpty()
           .or(textField2.textProperty().isEmpty())
           .or(
               checkBox1.selectedProperty()
                        .or(checkBox2.selectedProperty())
                        .or(checkBox3.selectedProperty()).not())
);