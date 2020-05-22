CallableStatement vStatement = vDatabaseConnection.prepareCall("{call mands.Lib_Interface.LoadData(?, ?) }");

StringReader reader = new StringReader(xml);
vStatement.registerOutParameter(1, Types.VARCHAR);
vStatement.setClob(2, reader);
vStatement.execute();
String msg = vStatement.getString(1);