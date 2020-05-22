private void zoom100(double x, double y) {
    double oldHeight = imageView.getBoundsInLocal().getHeight();
    double oldWidth = imageView.getBoundsInLocal().getWidth();

    boolean heightLarger = oldHeight>oldWidth;
    imageView.setFitHeight(-1);
    imageView.setFitWidth(-1);
    //calculate scale factor
    double scale=1;
    if(heightLarger){
        scale = imageView.getBoundsInLocal().getHeight()/oldHeight;
    }else {
        scale = imageView.getBoundsInLocal().getWidth()/oldWidth;
    }

    double centery = root.getLayoutBounds().getHeight() / 2;
    double centerx = root.getLayoutBounds().getWidth() / 2;

    double xOffset = scale * (centerx - x);
    double yOffset = scale *(centery - y);
    imageView.setTranslateX(xOffset);
    imageView.setTranslateY(yOffset);

}