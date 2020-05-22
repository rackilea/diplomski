private static class CustomRequestListener implements RequestListener<Uri, GlideDrawable> {
private CustomCallback cc;

public CustomRequestListener(CustomCallback cc) {
   this.cc = cc;
}

@Override public boolean onException(Exception e, Uri model, Target<GlideDrawable> target, boolean isFirstResource) {
    cc.stopProgressBar();
    return false;
}

@Override public boolean onResourceReady(GlideDrawable resource, Uri model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
    cc.stopProgressBar();
    return false;
}
}