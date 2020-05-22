File httpCacheDirectory = new File(applicationContext.getCacheDir(), "http-cache");
int cacheSize = 10 * 1024 * 1024; // 10 MiB
Cache cache = new Cache(httpCacheDirectory, cacheSize);
OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addNetworkInterceptor(new CacheInterceptor())
            .cache(cache)
            .build();