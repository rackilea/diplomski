public class MyComponent implements DataBindingComponent {
    @Override
    public ImageBindingAdapters getImageBindingAdapters() {
        //... whatever you do to create or retrieve the instance
        return imageBindingAdapter;
    }
}