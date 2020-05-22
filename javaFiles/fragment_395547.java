Button button = new Button();
    button.setOnAction(event -> {
        Thread t = new Thread(() -> {
            Platform.runLater(() -> field.setText("START"));
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Platform.runLater(() -> field.setText("END"));
        });

        t.start();
    });