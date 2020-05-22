@SuppressWarnings("unchecked")
static <T extends Visited> T copyObject(T payload) {
    CopyVisitor visitor = new CopyVisitor();
    payload.accept(visitor);
    return (T) visitor.getCopy();
}