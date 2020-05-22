tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

        @Override
        public void changed(ObservableValue<? extends Number> ov, Number t, final Number t1) {
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    if (tabPane.getTabs().size() > 0) {
                        final FileTab tab = (FileTab) tabPane.getTabs().get(t1.intValue());

                        final Timeline animation = new Timeline(
                                new KeyFrame(Duration.millis(25),
                                new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        Platform.runLater(new Runnable() {

                                            @Override
                                            public void run() {
                                                tab.getContent().requestFocus();
                                            }
                                        });
                                    }
                                }));
                        animation.setCycleCount(1);
                        animation.play();
                    }
                }
            });

        }
    });