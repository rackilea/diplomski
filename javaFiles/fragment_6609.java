class DatabaseRecord extends DatabaseEntity {

    protected String tableName = "DatabaseRecordTable";
    protected String idFieldName = "ID";

    public void getRecord() throws SQLException {


        DataRecord record = this.readFromDB(1);  

    }

    @Override
    public String getTableName() {
        return this.tableName;
    }

    @Override
    public String getIdFieldName() {
        return this.idFieldName ;
    }
}