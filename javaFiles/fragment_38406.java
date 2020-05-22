private static CacheManager getRawInstance() {
    lock.lock();
    try {
        final Field field = CacheManager.class.getDeclaredField("singleton");
        field.setAccessible(true); // << -- ??
        return (CacheManager) field.get(CacheManager.class);
    } catch (Exception e) {
        logger.error(e.getMessage(), e);
        return null;
    } finally {
        lock.unlock();
    }
}