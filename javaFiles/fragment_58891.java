class PromotedItemRecord {
    private PromotedItemRecord(Map<String, Object> record, source recordSource) {
        ... // Do the magic here
    }
    public static recordFromAjax(Map<String, Object> record) {
        return new PromotedItemRecord(record, source.fromAjax);
    }
    public static recordFromDb(Map<String, Object> record) {
        return new PromotedItemRecord(record, source.fromDb);
    }
}