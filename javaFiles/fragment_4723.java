DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
        .showImageForEmptyUri(R.drawable.content_picture)
        .showImageOnFail(R.drawable.content_picture)

        .resetViewBeforeLoading(false)
        .delayBeforeLoading(1000)
        .cacheOnDisc(true)
        .bitmapConfig(Bitmap.Config.RGB_565)
        .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
        .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity())
        .discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75, null)
        .threadPoolSize(5)
        .defaultDisplayImageOptions(defaultOptions)
        .denyCacheImageMultipleSizesInMemory()
        .discCacheSize(50 * 1024 * 1024)
        .writeDebugLogs()
        .build();


        ImageLoader.getInstance().init(config);

        ImageLoader.getInstance().handleSlowNetwork(true);