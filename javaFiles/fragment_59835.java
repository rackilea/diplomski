private static Map<String, Image> images = new HashMap<>();

...

Image image;
if ((image = images.get(item.getOwnerId())) == null) {
    img.setImage(null);
    new Thread(() -> {
        Image image1 = new Image(item.getOwnerProfilePicUrl());
        images.put(item.getOwnerId(), image1);
        Platform.runLater(() -> img.setImage(image1));
    }).start();
} else {
    img.setImage(image);
}