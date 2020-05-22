DoubleProperty xValue = new SimpleDoubleProperty();
    xValue.bind(circle.centerXProperty());
    xValue.addListener(new ChangeListener() {
        @Override
        public void changed(ObservableValue arg0, Object arg1, Object arg2) {

            System.out.println(" Current center X : " + (double) arg2);
        }
    });