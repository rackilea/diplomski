//in start method add this code
    DoubleProperty wProperty = new SimpleDoubleProperty();
    wProperty.bind(chatBox.widthProperty()); // bind to Hbox width chnages
    wProperty.addListener(new ChangeListener() {
        @Override
        public void changed(ObservableValue ov, Object t, Object t1) {
           //when ever Hbox width chnages set ScrollPane Hvalue
         chatBoxScrollPane.setHvalue(chatBoxScrollPane.getHmax()); 
        }
    }) ;