Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            Platform.runLater(()->{
                for (int i = 0; i<4; i++) {
                    Parent root = null;
                    try {
                        root = new FXMLLoader(getClass().getResource(View.ABBREVIATION)).load();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("deneme");
                    stage.showAndWait();
                }
            });
        }
    };

    timer.schedule(timerTask, 6000);