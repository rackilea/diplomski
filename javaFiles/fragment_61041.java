Bitmap bmp = ...;
boolean isBitmapInCache = false;
MemoryCacheAware<String, Bitmap> memoryCache = ImageLoader.getInstance().getMemoryCache();
for (String key : memoryCache.keys()) {
    if (bmp == memoryCache.get(key)) {
        isBitmapInCache = true;
        break;
    }
}

if (!isBitmapInCache) {
    // You can recycle bitmap
}