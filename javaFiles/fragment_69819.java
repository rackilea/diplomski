public class MyLabelProvider extends DecoratingLabelProvider {
    public Image getImage(Object element) {
        Image image = super.getImage(element);

        List<Object> images = new ArrayList<Object>(2);
        images.add(image);
        images.add(<Image of the decorator>);
        labelImage = new ComposedImage(images); // This will put the second of the "images" list (the decorator) above the first (the element's image)

        return decoratedImage;
    }
    [...]
}