Column column = new Column<RowObject, ImageResource>(new ImageResourceCell()) {

    @Override
    public ImageResource getValue(RowObject object) {
        if (showImageFor(object)) {
            return getImageResource();
        } else {
            return null;
        }
    }
};

cellTable.addColumn(column);