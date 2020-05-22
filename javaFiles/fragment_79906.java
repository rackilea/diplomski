public final synchronized List listRemoteCachePeers(Ehcache cache) throws CacheException {
    List remoteCachePeers = new ArrayList();
    List staleList = new ArrayList();
    for (Iterator iterator = peerUrls.keySet().iterator(); iterator.hasNext();) {
        String rmiUrl = (String) iterator.next();
        String rmiUrlCacheName = extractCacheName(rmiUrl);

        if (!rmiUrlCacheName.equals(cache.getName())) {
            continue;
        }
        Date date = (Date) peerUrls.get(rmiUrl);
        if (!stale(date)) {
            CachePeer cachePeer = null;
            try {
                cachePeer = lookupRemoteCachePeer(rmiUrl);
                remoteCachePeers.add(cachePeer);
            } catch (Exception e) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Looking up rmiUrl " + rmiUrl + " through exception " + e.getMessage()
                            + ". This may be normal if a node has gone offline. Or it may indicate network connectivity"
                            + " difficulties", e);
                }
            }
        } else {
                LOG.debug("rmiUrl {} should never be stale for a manually configured cluster.", rmiUrl);
            staleList.add(rmiUrl);
        }

    }

    //Remove any stale remote peers. Must be done here to avoid concurrent modification exception.
    for (int i = 0; i < staleList.size(); i++) {
        String rmiUrl = (String) staleList.get(i);
        peerUrls.remove(rmiUrl);
    }
    return remoteCachePeers;
}