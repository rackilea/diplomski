interface ResultSet2 {
    int findColumn(String columnLabel);
    String getString(int index);
    long getLong(int index);
    default long getLong(String columnLabel) {
        return getLong(findColumn(columnLabel));
    }
    default String getString(String columnLabel) {
        return getString(findColumn(columnLabel));
    }
}