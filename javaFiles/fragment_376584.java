ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(thisContext)
            // You can pass your own memory cache implementation
           .discCacheFileNameGenerator(new HashCodeFileNameGenerator())
           .build();

DisplayImageOptions options = new DisplayImageOptions.Builder()
            .displayer(new RoundedBitmapDisplayer(10)) //rounded corner bitmap
            .cacheInMemory(true)
            .cacheOnDisc(true)
            .build();

ImageLoader imageLoader = ImageLoader.getInstance();
imageLoader.init(config);
imageLoader.displayImage(image_url,image_view, options );