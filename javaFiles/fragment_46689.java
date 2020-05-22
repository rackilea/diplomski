lw.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        if(newValue != null) {
            String[] conParts = newValue.split("@");
            String selectedConName = conParts[0];
            number = conParts[1];
            selectedName = selectedConName;
            displayTF(selectedName);
        }

    }
});