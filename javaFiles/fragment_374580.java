ConcurrentHashMap<String, CachedFile> myCache = ConcurrentHashMap<>();
CachedFile newFile = new CachedFile(<path>);
CachedFile file = myCache.putIfAbsent(<path>, newFile);
// Use the new file if it did not exist
if (file == null) file = newFile;
// This will be no-op if already cached, or will block is someone is caching this file.
file.cache();
// Now return the cached file.
return file.getFile();