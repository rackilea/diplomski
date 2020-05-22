public void addElement(int bucketId, Element element) {
    Bucket bucket = em.find(Bucket.class, bucketId);
    em.lock(bucket, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
    bucket.add(element);
    element.setBucket(bucket);
}