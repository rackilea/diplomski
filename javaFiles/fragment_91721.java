public String getId(Test.Entity entity) throws Throwable {
    return entity.legacyIndicator()
        .map(o -> (Optional) entity.legacyId())
        .orElseGet(() -> (Optional) entity.newId())
        .orElseThrow(() -> new IOException("No ID found."))
        .toString();
}