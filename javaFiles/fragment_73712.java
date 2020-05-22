Path [] cacheFiles = DistributedCache.getLocalCacheFiles(conf);
      if (null != cacheFiles && cacheFiles.length > 0) {
        for (Path cachePath : cacheFiles) {
          if (cachePath.getName().equals(stopwordCacheName)) {
            loadStopWords(cachePath);
            break;
          }
        }