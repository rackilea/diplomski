class Foo {
    private Cursor theCursor;

    private synchronized Cursor getAllContactsCached() {
        if (this.theCursor == null) {
            this.theCursor = this.getList();
        }
        return this.theCursor;
    }
}