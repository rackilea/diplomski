EventHandler mouseHandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent t) {
        ImageView imageView = (ImageView) t.getSource();
        System.out.println("You clicked " + imageView.getImage());
    }
};

for (int i = 0; i < 8; i++) {
    ImageView imageView = new ImageView(im[i]);
    imageView.setOnMouseClicked(mouseHandler);
    flowpane.getChildren().add(imageView);
}