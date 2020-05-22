public abstract class MyRepository<T extends DatabaseObject> {

    private Class<T> type;

    public MyRepository(Class<T> type) {
      this.type = type;
    }

    public <T> List<T> getList() {
      Cursor cursor = getCursor(null, null); // how to do this?
      // excess code removed, rest of function not relevant to question
      return null;
    }

    protected <T extends DatabaseObject> Cursor getCursor(String selection, String[] selectionArgs) {
      DatabaseObject databaseObject = instantiateFromType(); // how to do this?
      String tableName = databaseObject.getTableName();
      String[] projection = databaseObject.getProjection();
      String sortOrder = databaseObject.getDefaultOrderColumn() + " " + DEFAULT_SORT_ORDER;
      Cursor cursor = database.query(
        tableName,
        projection,
        selection,
        selectionArgs,
        null,
        null,
        sortOrder);
      return cursor;
    }

    private DatabaseObject instantiateFromType() {
      try {
          T interfaceType = (T) type.newInstance();
          return interfaceType;
      }
      catch (Exception e) {
          // TODO to handle
       }         
    }
}