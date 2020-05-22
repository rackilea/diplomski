DisplayImageOptions
            options = new DisplayImageOptions.Builder()
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .showImageOnLoading(R.drawable.no_image) // resource or drawable
            .showImageForEmptyUri(R.drawable.no_image) // resource or drawable
            .showImageOnFail(R.drawable.no_image)
            .considerExifParams(true)
            .bitmapConfig(Bitmap.Config.RGB_565)
            .build();

    imageLoader1.displayImage(yourpath.replace(" ", "%20"), ivprofile, options);