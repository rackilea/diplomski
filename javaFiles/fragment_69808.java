public class SearchableTableWrapper implements SearchableTable<MyItemType> {

    private final Table wrappedThirdPartyTable;

    public SearchableTableWrapper(Table wrappedThirdPartyTable) {
        this.wrappedThirdPartyTable = wrappedThirdPartyTable;
    }

    public MyItemType getItem(int x, int y) {
         ...
    }
}