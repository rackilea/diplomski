Column column = new Column<RowObject, ColumnObject>(new CustomCell()) {
    @Override
    public ColumnObject getValue(RowObject object) {
        return getColumnObjectFrom(object);
    }
};

cellTable.add(column);