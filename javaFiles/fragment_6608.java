abstract class DatabaseEntity {

   //  protected String tableName;
   //  protected String idFieldName;

    public abstract String getTableName();



    public abstract String getIdFieldName() ;

    public DataRecord readFromDB(int recordID) throws SQLException {

        ...
        String sqlStatement = String.format("SELECT * FROM %s WHERE %s = %s",getTableName(), getIdFieldName(), recordID);
        ...
    }
}