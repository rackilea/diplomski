@Override
    protected void onActivityResult(int RC, int RQC, Intent I) {
        super.onActivityResult(RC, RQC, I);
        if (RC == 1 && RQC == RESULT_OK && I != null && I.getData() != null) {
            Uri uri = I.getData();
            RequestOptions options = new RequestOptions()
                    .format(DecodeFormat.PREFER_RGB_565)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background);

            Glide.with(this)
                    .setDefaultRequestOptions(options)
                    .asBitmap()
                    .load(uri)
                    .centerInside()
                    .into(new CustomTarget<Bitmap>(512, 512) {
                        @Override
                        public void onResourceReady(@NonNull Bitmap bitmap1, @Nullable Transition<? super Bitmap> transition) {
                            imageView1.setImageBitmap(bitmap1);
                            MainActivity.this.bitmap1 = bitmap1;
                        }

                        @Override
                        public void onLoadCleared(@Nullable Drawable placeholder) {
                        }
                    });
        }