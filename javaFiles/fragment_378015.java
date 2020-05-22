...
    System.out.println("plazaNameLocation");
    javafx.application.Platform.runLater( () ->
        LsduFrameController.PlazaNameData.setText(plazaNameLocation);
    );
    rs.close();
    ...