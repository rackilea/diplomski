primaryStage.fullScreenProperty().addListener(new ChangeListener<Boolean>() {

        @Override
        public void changed(ObservableValue<? extends Boolean> observable,
                Boolean oldValue, Boolean newValue) {
            if(newValue != null && !newValue.booleanValue())
                primaryStage.setFullScreen(true);
        }
    });