String insertXML = "insert into WS_NAPACQ00T (IDE_IDEN, CLB_CXML, SYS_DATE) values (?, ?, ?) ";
PreparedStatement statement = connection.prepareStatement(insertXML);
statement.setString(1,"10");
statement.setString(2,"test");
statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
result = statement.executeQuery();