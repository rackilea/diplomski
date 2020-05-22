TextField textField = new TextField();

    // converter that converts text to Integers, and vice-versa:
    StringConverter<Integer> stringConverter = new StringConverter<Integer>() {

        @Override
        public String toString(Integer object) {
            if (object == null || object.intValue() == 0) {
                return "";
            }
            return object.toString() ;
        }

        @Override
        public Integer fromString(String string) {
            if (string == null || string.isEmpty()) {
                return 0 ;
            }
            return Integer.parseInt(string);
        }

    };

    // filter only allows digits, and ensures only one digit the text field:
    UnaryOperator<Change> textFilter = c -> {

        // if text is a single digit, replace current text with it:            
        if (c.getText().matches("[1-9]")) {
            c.setRange(0, textField.getText().length());
            return c ;
        } else 
        // if not adding any text (delete or selection change), accept as is    
        if (c.getText().isEmpty()) {
            return c ;
        }
        // otherwise veto change
        return null ;
    };

    TextFormatter<Integer> formatter = new TextFormatter<Integer>(stringConverter, 0, textFilter);

    formatter.valueProperty().addListener((obs, oldValue, newValue) -> {
        // whatever you need to do here when the actual value changes:
        int old = oldValue.intValue();
        int updated = newValue.intValue();
        System.out.println("Value changed from " + old + " to " + new);
    });

    textField.setTextFormatter(formatter);