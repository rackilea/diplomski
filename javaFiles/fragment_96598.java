String[] imageResources = new String[] {
    "facebook.png",
    "faviicon.png", 
    // etc
};

// ...

for (final String imageResource : imageResources) {
    Image image = new Image(getClass().getResourceAsStream(imageResource));
    ImageView imageView = new ImageView(image);
    imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            System.out.println("You clicked: "+imageResource);
        }
    });
    flowPane.getChildren().add(imageView);
}