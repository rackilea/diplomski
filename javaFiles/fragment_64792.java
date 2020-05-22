public static void loadImage(Context ctx,RequestOptions glideRequests, String url, ImageView imageView) {
        loadImage(ctx,glideRequests, url, imageView, DiskCacheStrategy.ALL);
    }

    public static void loadImage(Context ctx,RequestOptions glideRequests, String url, ImageView imageView, DiskCacheStrategy diskCacheStrategy) {

                 Glide.with(ctx)
                    .applyDefaultRequestOptions(requestOptions.placeholder(R.drawable.ic_stub).error(R.drawable.ic_stub))
                    .asBitmap()
                    .load(url).into(imageView);
    }