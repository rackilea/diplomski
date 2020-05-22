mDB.addBookmark(
        Long.valueOf(bookmark.getId()),
        bookmark.getName(),
        bookmark.getViewType() > 0,
        iconName(bookmark.getIcon()),
        bookmark.getNativeUrl(),
        bookmark.getSearchUrl()
);

String Icon = csr.getString(csr.getColumnIndex(COL_ICON));
b.setIcon(iconRes(Icon));