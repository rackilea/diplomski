public class MyApplication extends Application {


   public static void initImageLoader(Context context) {

      File cacheDirectory = StorageUtils.getOwnCacheDirectory(context, ApplicationConstant.IMAGE_CACHE_DIRECTORY);
      ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2)
                                                                                     .threadPoolSize(5)
                                                                                     .denyCacheImageMultipleSizesInMemory()
                                                                                     .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                                                                                     .memoryCacheSize(50 * 1024 * 1024)
                                                                                     .diskCache(new UnlimitedDiscCache(cacheDirectory))
                                                                                     .tasksProcessingOrder(QueueProcessingType.LIFO)
                                                                                     .writeDebugLogs()
                                                                                     .build();
      // Initialize ImageLoader with configuration.
      ImageLoader.getInstance().init(config);

   }

   @Override
   public void onCreate() {
      super.onCreate();
      initImageLoader(getApplicationContext());
   }
}