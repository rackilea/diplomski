final Image playedImage = new Image(...);

hasBeenPlayed.setCellFactory(col -> new TableCell<Media, Boolean>() {
    private final ImageView image = new ImageView();

    {
        setGraphic(image);
        image.setFitWidth(playedImage.getWidth());
        image.setFitHeight(playedImage.getHeight());
    }

    @Override
    protected void updateItem(Boolean item, boolean empty) {
         super.updateItem(item, empty);

         // set the image according to the played state
         image.setImage(item != null && item ? playedImage : null);
    }
});