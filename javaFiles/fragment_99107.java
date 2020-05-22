SQLServerDataTable sourceDataTable = new SQLServerDataTable();   
sourceDataTable.addColumnMetadata("SDate", java.sql.Types.DECIMAL);
sourceDataTable.addColumnMetadata("EDate", java.sql.Types.DECIMAL);
sourceDataTable.addColumnMetadata("PlantCode", java.sql.Types.NVARCHAR);
sourceDataTable.addColumnMetadata("LoadType", java.sql.Types.NCHAR);
sourceDataTable.addColumnMetadata("Asset", java.sql.Types.BIGINT);

// sample data
sourceDataTable.addRow(123, 234, "Plant1", "Type1", 123234);   
sourceDataTable.addRow(456, 789, "Plant2", "Type2", 456789);   

try (CallableStatement cs = conn.prepareCall("{CALL dbo.RegisterInitAssets (?)}")) {
    ((SQLServerCallableStatement) cs).setStructured(1, "dbo.INITVALS_MSG", sourceDataTable);
    boolean resultSetReturned = cs.execute();
    if (resultSetReturned) {
        try (ResultSet rs = cs.getResultSet()) {
            rs.next();
            System.out.println(rs.getInt(1));
        }
    }
}