ObservableList<TextField> oList = 
        FXCollections.observableArrayList(tf -> new Observable[]{tf.textProperty()});  

    oList.addListener((ListChangeListener.Change<? extends TextField> c) -> {
        while (c.next()) {
            if (c.wasUpdated()) {
                for (int i = c.getFrom(); i < c.getTo(); ++i) {
                    System.out.println("Updated index: " + i + ", new value: " + c.getList().get(i).getText());
                }
            }
        }
    });