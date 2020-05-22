public class BindingCustom {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(final ImageView view, String url) {

        Picasso.with(view.getContext()).load(url).into(view);

    }
}