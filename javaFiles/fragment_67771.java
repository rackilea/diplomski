@Override
    public void start(Stage stage) {
        ...    
    PlatformService.getInstance().messageProperty().addListener(
        (obs,s,s1)->{
            Platform.runLater(()->incoming.setText(s1.toString()));
        });

        // start broadcast
        PlatformService.getInstance().listenToIncomingSMS();
    }