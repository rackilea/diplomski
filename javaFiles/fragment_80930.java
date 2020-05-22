private final Map<Image, String> imageSources = new WeakHashMap();

public Image loadImage(String url) {
    Image image = new Image(url);
    imageSources.put(image, url);
    return image;
}

public String getURLFromImage(Image image) {
    retrun imageSources.get(image);
}