abstract public class DbTable<R extends DbRow> {  

    protected DbTable(DbPlatform platform, String tableName) {  }

    static class TableList<T extends DbTable<?>> extends ArrayList<T> {}

    static class PlatformTableList<T extends DbTable<?>> 
                    extends PairList<DbPlatform, TableList<T>> {}

    /** Return the matching DbTable with matching DbSelectStatement or null.
     * Will create/add a new TableList if platform not found. */

    static protected <T extends DbTable<?>> T getTable(PlatformTableList<T> platformList, 
            DbPlatform platform, DbSelectStatement stmt) {

        // Get the table from the list, or create new
        TableList<T> list = getCreateTableList(platformList, platform);
        // Search the list for a match
        for(T table : list) {
            if(table.equals(stmt))
                return table;
        }
        return null; 
    }

    /** Get or create and return a TableList for the Platform.  */
    static protected <T extends DbTable<?>> TableList<T> getCreateTableList(
            PlatformTableList<T> platformList, DbPlatform platform) { 

        TableList<T> list = platformList.getRightForLeft(platform);
        if(list == null) {
            list = new TableList<T>();
            platformList.addEntry(platform, list);            
        }
        return list;
    }

}