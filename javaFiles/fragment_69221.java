public void method(){
    final Activity activity = getCurrentActivity();
            activity.runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    int counter = sources.size();
                    for (int i = 0; i < sources.size(); i++) {


                        final ReadableMap source = sources.getMap(i);
                        final GlideUrl glideUrl = FastImageViewConverter.glideUrl(source);
                        final Priority priority = FastImageViewConverter.priority(source);
                        Glide
                                .with(activity.getApplicationContext())
                                .load(glideUrl)
                                .priority(priority)
                                .placeholder(TRANSPARENT_DRAWABLE)
                                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                .preload()
                                .listener(new RequestListener<Uri, GlideDrawable>() {
                                    @Override public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
                                        counter--;
                                        if counter == 0 {
                                            return your result here
                                        }
                                        return false;
                                    }
                                    @Override public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                        counter--;
                                        if counter == 0 {
                                            return your result here
                                        }
                                        return false;
                                        // impossible?
                                    }
                                });
                    }
                }
            });

}