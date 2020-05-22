public class ImageBindingAdapters {
    private ImageLoader imageLoader;

    public ImageBindingAdapters(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    @BindingAdapter("url")
    public void setImageUrl(ImageView imageView, String url) {
        imageLoader.loadInto(imageView, url);
    }
}