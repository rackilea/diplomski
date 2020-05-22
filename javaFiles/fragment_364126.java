List<CacheCluster> cacheClusters = clusterResult.getCacheClusters();
for (CacheCluster cacheCluster : cacheClusters) {
    List<CacheNode> cacheNodes = cacheCluster.getCacheNodes();

    System.out.println("List size: " + cacheNodes.size());
}