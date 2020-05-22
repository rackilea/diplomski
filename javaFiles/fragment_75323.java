Connection vDatabaseConnection = DriverManager.getConnection("jdbc:oracle:thin:@xx.xxx.xx.xxx:1521:xxx", "user","pass");
    CallableStatement vStatement = vDatabaseConnection.prepareCall("begin mands.Lib_Interface.LoadData(?, ?); end;");

    StringReader reader = new StringReader(xml);
    vStatement.registerOutParameter(1, Types.VARCHAR);
    vStatement.setClob(2, reader);
    vStatement.execute();
    String msg = vStatement.getString(1);