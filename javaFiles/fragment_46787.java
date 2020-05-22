public void initStage(Stage stage){
     primaryStage = stage;
     escenaAnterior = stage.getScene();
     tituloAnterior = stage.getTitle();
     primaryStage.setTitle("Window 1");
     someLabelFromFXML.setText(tituloAnterior);
 }