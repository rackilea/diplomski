/* Loads images smoothly in ListView */


public class AlbumArtLoader {
    private Context ctx;
    private int artSize;
    private final Bitmap mPlaceHolderBitmap;
    private Drawable[] drawables = new Drawable[2];
    public AlbumArtLoader(Context c) {
        ctx = c;
        artSize = c.getResources().getDimensionPixelSize(R.dimen.albumart_size);
        mPlaceHolderBitmap = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.transparent);
        mPlaceHolderBitmap = Bitmap.createScaledBitmap(mPlaceHolderBitmap, artSize, artSize, false);
        drawables[0] = new BitmapDrawable(ctx.getResources(), mPlaceHolderBitmap);
    }
    class BitmapWorkerTask extends AsyncTask<String, Void, TransitionDrawable> {
        private final WeakReference<ImageView> imageViewReference;
        private String path;
        public BitmapWorkerTask(ImageView imageView) {
            // Use a WeakReference to ensure the ImageView can be garbage collected
            imageViewReference = new WeakReference<ImageView>(imageView);
        }
        // Decode image in background.
        @Override
        protected TransitionDrawable doInBackground(String... params) {
            path = params[0];
            // TransitionDrawable let you to make a crossfade animation between 2 drawables
            // It increase the sensation of smoothness
            TransitionDrawable td = null;

            // The albumart_unknown bitmap is recreated for each album without album art to maintain even scrolling
            if(path == null) {
                Bitmap b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.albumart_unknown), artSize, artSize, true);
                drawables[1] = new BitmapDrawable(ctx.getResources(), b);
            } else {
                Bitmap b;
                try {
                    b = Bitmap.createScaledBitmap(BitmapFactory.decodeFile(path), artSize, artSize, true);
                } catch(Exception e) {
                    b = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(ctx.getResources(), R.drawable.albumart_unknown), artSize, artSize, true);
                }
                drawables[1] = new BitmapDrawable(ctx.getResources(), b);
            }
            td = new TransitionDrawable(drawables);
            td.setCrossFadeEnabled(true);
             return td;
        }
        // Once complete, see if ImageView is still around and set bitmap.
        @Override
        protected void onPostExecute(TransitionDrawable td) {
            if(isCancelled()) {
                td = null;
            }
            if(imageViewReference != null && td != null) {
                final ImageView imageView = imageViewReference.get();
                final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
                if(this == bitmapWorkerTask && imageView != null) {
                    imageView.setImageDrawable(td);
                    td.startTransition(200);
                }
            }
        }
    }

    public void loadBitmap(String path, ImageView imageView) {
        if(cancelPotentialWork(path, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(imageView);
            final AsyncDrawable asyncDrawable = new AsyncDrawable(ctx.getResources(), mPlaceHolderBitmap, task);
            imageView.setImageDrawable(asyncDrawable);
            task.execute(path);
        }
    }

    static class AsyncDrawable extends BitmapDrawable {
        private final WeakReference<BitmapWorkerTask> bitmapWorkerTaskReference;
        public AsyncDrawable(Resources res, Bitmap bitmap, BitmapWorkerTask bitmapWorkerTask) {
            super(res, bitmap);
            bitmapWorkerTaskReference = new WeakReference<BitmapWorkerTask>(bitmapWorkerTask);
        }
        public BitmapWorkerTask getBitmapWorkerTask() {
            return bitmapWorkerTaskReference.get();
        }
    }

    public static boolean cancelPotentialWork(String path, ImageView imageView) {
        final BitmapWorkerTask bitmapWorkerTask = getBitmapWorkerTask(imageView);
        if(bitmapWorkerTask != null) {
            final String bitmapData = bitmapWorkerTask.path;
            // If bitmapData is not yet set or it differs from the new data
            if(bitmapData == null || bitmapData != path) {
                // Cancel previous task
                bitmapWorkerTask.cancel(true);
            } else {
        // The same work is already in progress
                return false;
            }
        }
        // No task associated with the ImageView, or an existing task was cancelled
        return true;
    }

    // Helper method
    private static BitmapWorkerTask getBitmapWorkerTask(ImageView imageView) {
        if(imageView != null) {
            final Drawable drawable = imageView.getDrawable();
            if(drawable instanceof AsyncDrawable) {
                final AsyncDrawable asyncDrawable = (AsyncDrawable) drawable;
                return asyncDrawable.getBitmapWorkerTask();
            }
        }
        return null;
    }
}