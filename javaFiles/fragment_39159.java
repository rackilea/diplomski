TextField textField = new TextField();
textField.setPromptText("Enter something");

PseudoClass empty = PseudoClass.getPseudoClass("empty");

textField.pseudoClassStateChanged(empty, textField.getText().isEmpty());

textField.textProperty().isEmpty().addListener((obs, wasEmpty, isNowEmpty) -> 
        textField.pseudoClassStateChanged(empty, isNowEmpty));