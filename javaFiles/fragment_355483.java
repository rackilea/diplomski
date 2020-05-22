ImageView imageView = new ImageView(im[i]);
imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent t) {
        System.out.println("Oh dear lord, they clicked me!?");
    }
});