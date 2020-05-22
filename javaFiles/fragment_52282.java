if (imageView.isPreserveRatio()) {
    if (getHeight() > getWidth()) {
        imageView.setFitWidth(getWidth());
        imageView.setFitHeight(0);
    } else {
        imageView.setFitWidth(0);
        imageView.setFitHeight(getHeight());
    }
} else {
    imageView.setFitWidth(getWidth());
    imageView.setFitHeight(getHeight());
}