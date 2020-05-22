String jdbcurl = "jdbc:sqlserver://TestServer:1433;DatabaseName=Student";
connection = DriverManager.getConnection(jdbcurl,"username","password");

SQLServerDataTable stuTypeDT = new SQLServerDataTable(); 
stuTypeDT.addColumnMetadata("StudentId", java.sql.Types.NUMERIC);
stuTypeDT.addColumnMetadata("Name", java.sql.Types.VARCHAR);
stuTypeDT.addColumnMetadata("Department", java.sql.Types.VARCHAR);
stuTypeDT.addColumnMetadata("Address", java.sql.Types.VARCHAR);

stuTypeDT.addRow("1","Tom", "A", "123 Street");
stuTypeDT.addRow("2","Jery", "B", "456 Street");
stuTypeDT.addRow("3","Mac", "C", "Vancour");

String ececStoredProc = "EXEC InsertStudentInfo ?";
SQLServerPreparedStatement pStmt = (SQLServerPreparedStatement)connection.prepareStatement(ececStoredProc);
pStmt.setStructured(1, "dbo.StudentInfoType", stuTypeDT);
pStmt.execute();