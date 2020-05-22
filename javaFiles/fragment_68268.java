XBookmarksSupplier xBookmarksSupplier =
    (XBookmarksSupplier)UnoRuntime.queryInterface(
    XBookmarksSupplier.class, xComponent);
    XNameAccess xNamedBookmarks = xBookmarksSupplier.getBookmarks();
Object bookmark = xNamedBookmarks.getByName("TextAndTable");
XTextContent xBookmarkContent = (XTextContent)UnoRuntime.queryInterface(
    XTextContent.class, bookmark);
XTextRange xTextRange = xBookmarkContent.getAnchor();