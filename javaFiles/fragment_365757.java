final Popup popup = new Popup();
    final ImageView popupImage = new ImageView(image.getImage());
    popup.getContent().add(popupImage);
    popup.setOnShown(new EventHandler<WindowEvent>(){
     @Override
     public void handle(WindowEvent t) {
         popupImage.setFitHeight(400);
         popupImage.setFitWidth(400);

     }
});

   popup.show(stage);