class Cols_Iterables2<N> extends Iterable2<Column<N>> { 
    ColumnList<N> columns;

    public Cols_Iterables2(ColumnList<N> columnList) {
        this.columns = columnList;
    }

    @Override
    public Column<N> get(int index) {
        return columns.getColumnByIndex(index);
    }
}