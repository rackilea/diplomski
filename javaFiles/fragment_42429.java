configRegistry.registerConfigAttribute(
    CellConfigAttributes.CELL_PAINTER, 
    new CheckBoxPainter(
        ImageUtil.getImage("Images.BookmarkChecked"),
        ImageUtil.getImage("Images.BookmarkUnchecked")),
    DisplayMode.SELECT, 
    COLUMN_BOOKMARK_LABEL);