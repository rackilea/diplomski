@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        int cropperType = 1;
        if (requestCode == REQUEST_IMAGE_CAPTURE) {

            switch (resultCode) {
                case Activity.RESULT_OK:

                     String imagePAth= Uri.fromFile(IMAGE_PATH);
                GlideApp.with(this).load(imagePAth).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(false).
                        placeholder(R.drawable.default_picture).error(R.drawable.default_picture).dontAnimate().into(YOUR_IMAGEVIEW);

                    break;
                case Activity.RESULT_CANCELED:

                    break;
            }
        }

    }