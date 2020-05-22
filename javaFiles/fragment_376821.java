private void SetUserIconForPlayer(final Player player, Uri uri)
{
    ImageManager mgr = ImageManager.create(application);
    mgr.loadImage(new ImageManager.OnImageLoadedListener() {
        @Override
        public void onImageLoaded(Uri uri,final Drawable drawable, boolean isRequestedDrawable) {
            if(isRequestedDrawable)
            {
                Gdx.app.postRunnable(new Runnable() {
                    @Override
                    public void run() {
                        player.SetUserIcon(GetTextureFromDrawable(drawable));
                    }
                });
            }
        }
    }, uri);
}