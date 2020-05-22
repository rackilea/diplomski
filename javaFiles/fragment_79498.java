@Autowired
private CacheManager cacheManager;

public void addReceipt(ReceiptObject receiptObject) throws Exception {
    feedbackDao.insertReceipt(receiptObject);
    Cache cache = cacheManager.getCache("assignedFeedbacks");
    for (Object receiptId: receiptObject.getResolverIds()) {
        cache.evict(receiptId);
    }
}