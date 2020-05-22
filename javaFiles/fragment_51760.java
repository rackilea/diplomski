tabPane.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

        @Override
        public void changed(ObservableValue<? extends Number> ov, Number t, final Number t1) {
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                    if (tabPane.getTabs().size() > 0) {
                        final FileTab tab = (FileTab) tabPane.getTabs().get(t1.intValue());

                        final Timer timer = new Timer();
                        timer.schedule(new TimerTask() {

                            @Override
                            public void run() {
                                Platform.runLater(new Runnable() {

                                    @Override
                                    public void run() {
                                        tab.getContent().requestFocus();
                                        timer.cancel();
                                        timer.purge();
                                    }
                                });
                            }
                        }, 25);
                    }
                }
            });

        }
    });