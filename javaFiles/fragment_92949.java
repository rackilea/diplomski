final ImagePojo imagePojo = new ImagePojo();
imagePojo.setName("superman");
imagePojo.setImageContent(new byte[0]);

BeanItem<ImagePojo> item = new BeanItem<ImagePojo>(imagePojo);


final StreamResource imageResource = new StreamResource(new StreamResource.StreamSource() {
    @Override
    public InputStream getStream() {
        return new ByteArrayInputStream(imagePojo.getImageContent());
    }
}, "myimage");
imageResource.setCacheTime(0);

final Image image = new Image("Image", imageResource);
addComponent(image);