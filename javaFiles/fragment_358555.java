Platform.runLater(new Runnable(){
  public void run() {                      

     if(imgView == null)
       imgView = new imgView();
     imgView.setImage(screenImg);
     imgView.setFitWidth(468);
     imgView.setFitHeight(620);
     StackPane sp = new StackPane();
     sp.getChildren().add(imgView);
     }
});