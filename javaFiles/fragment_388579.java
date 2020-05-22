private BottomPanel(){
    setSize(600, 100);
    setLocation(0, 500);
    setLayout(null);

    Platform.runLater(new Runnable(){
       @Override
       public void run(){
           getScenePane().getChildren().addAll(getBtn1(),getBtn2(),getBtn3());
           getjfxPanel().setScene(new Scene(getScenePane()));
       }
    });
    add(getjfxPanel());
}