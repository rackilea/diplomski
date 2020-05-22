choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
  {
     @Override
     public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue)
     {
        System.out.println(observable + oldValue + newValue);
     }
  });

  choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
     System.out.println(observable + oldValue + newValue);
  });

  choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> System.out.println(observable + oldValue + newValue));