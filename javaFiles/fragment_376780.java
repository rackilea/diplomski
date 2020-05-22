//viewCategory.getSelectionModel().setCellSelectionEnabled(true);
    //viewCategory.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    viewCategory.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number1) {
                    if ((Integer) number1 >= 0) {
                        Category cat = (Category) table.getItems().get(number1);
                        String id = cat.getid();
                        \\here you can fetch DB for aditional info and pass it somewhere
                    } 
                }
            });