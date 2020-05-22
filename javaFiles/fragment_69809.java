public class TableUtils {

    private static Map<Long, SearchableTable> tableIdToSearchableTable;

    public static <T> T getItem(SearchableTable<T> table, int x, int y) {
        return table.getItem(x, y);
    }
}