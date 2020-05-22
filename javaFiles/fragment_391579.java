private String findTokenText(JsonParser jp, String fieldName) throws IOException {
    JsonParser parser = getResetParser(jp);
    while (true) {
        parser.nextToken();
        if (parser.hasCurrentToken()) {
            switch (parser.getCurrentToken()) {
                case END_ARRAY:
                case END_OBJECT:
                case NOT_AVAILABLE:
                case START_ARRAY:
                case START_OBJECT:
                case VALUE_EMBEDDED_OBJECT:
                case VALUE_FALSE:
                case VALUE_NUMBER_FLOAT:
                case VALUE_NUMBER_INT:
                case VALUE_TRUE:
                    // do nothing
                    break;
                case FIELD_NAME:
                    String currentName = parser.getCurrentName();
                    if (fieldName.equals(currentName)) {
                        parser.nextToken();
                        return parser.getText();
                    }
                    break;
            }
        } else {
            return null;
        }
    }