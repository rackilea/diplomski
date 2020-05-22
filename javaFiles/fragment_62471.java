GridPane pne  =new GridPane();
    pne.widthProperty().addListener(new ChangeListener<Number>
    () {

        @Override
        public void changed(ObservableValue<? extends Number> ov, Number t, Number t1) {
            System.out.println("now do here what you want with inner objects");
        }
    });