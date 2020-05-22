/**
 * Evicts all second level cache hibernate entites. This is generally only
 * needed when an external application modifies the game databaase.
 */
public void evict2ndLevelCache() {
    try {
        Map<String, ClassMetadata> classesMetadata = sessionFactory.getAllClassMetadata();
        Cache cache = sessionFactory.getCache();
        for (String entityName : classesMetadata.keySet()) {
            logger.info("Evicting Entity from 2nd level cache: " + entityName);
            cache.evictEntityRegion(entityName);
        }
    } catch (Exception e) {
        logger.logp(Level.SEVERE, "SessionController", "evict2ndLevelCache", "Error evicting 2nd level hibernate cache entities: ", e);
    }
}