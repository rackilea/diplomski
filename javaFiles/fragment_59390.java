ComboBox<String> c1 = new ComboBox<String>();
    c1.getItems().addAll("red", "blue", "green");

    ComboBox<String> c2 = new ComboBox<String>();
    c2.getItems().addAll("yellow", "purple", "blue");

    c1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
        @Override
        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
            String val = (String) newValue;
            if(val.equals(c2.getValue())){
                System.out.println("IT'S SAME");
            } else {
                System.out.println("Keep trying");
            }
        }
    });