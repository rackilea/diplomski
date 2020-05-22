public class TableDef {
  private final String tableName;
  private final Map<String, String> colDef = new LinkedHashMap<String, String>();

  public TableDef(String tableName) {
     this.tableName = tableName;
  }

  public void addColumn(String name, String type) {
    if (colDef.containsKey(name))
      throw new IllegalArgumentException(name + " column already added");
    colDef.put(name, type);
  }

  public String getCreateTable() {
    String ddl = "CREATE TABLE " + tableName + "(";
    for (Map.Entry<String, String> col : colDef.entrySet()) {
      // add column to ddl
    }
    return ddl + ")";
  }
}