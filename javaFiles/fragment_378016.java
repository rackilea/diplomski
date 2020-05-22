...
    System.out.println("plazaNameLocation");
    javafx.application.Platform.runLater( new Runnable() {
        @Override
        public void run() {
            LsduFrameController.PlazaNameData.setText(plazaNameLocation);
        }
    });
    rs.close();
    ...