public <U extends CursorPointer<TElement>> U reQuery() {

    try {
        return (U) reQueryHandler == null ? null : reQueryHandler.query();
    } finally {
        this.close();
    }
}