public class ImageButton extends Button {

    public ImageButton(@NamedArg("image") Image image, @NamedArg("text") String text) {
        setImage(image);
        setText(text);
    }

    private final ObjectProperty<Image> image = new SimpleObjectProperty<>(this, "image") {
        @Override
        protected void invalidated() {
            // setGraphic(new ImageView(get()));
            setEffect(new ImageInput(get()));
        }
    };

    public final ObjectProperty<Image> imageProperty() {
       return image;
    }

    public final Image getImage() {
       return image.get();
    }

    public final void setImage(Image value) {
        image.set(value);
    }
}