ObjectProperty<Integer> objP = new SimpleObjectProperty<>();
    stringProperty.bindBidirectional(objP, new StringConverter<Integer>() {
        @Override
        public String toString(Integer number) {
            return number == null ? "NULL" : number.toString();
        }

        @Override
        public Integer fromString(String string) {
            return string.equals("NULL") ? null : Integer.valueOf(string); 
        }
    });

    // both works:
    objP.setValue(null);
    objP.setValue(100);