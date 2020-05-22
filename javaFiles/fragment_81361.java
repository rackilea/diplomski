CallableStatement stmt = con.prepareCall("{ call myInsert(?, ?, ?, ?)}");
stmt.setString(1, myTO.getField1());
stmt.setString(2, myTO.getField2());
stmt.setString(3, myTO.getField3());
stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
stmt.executeUpdate();
System.out.println(stmt.getString(4)); // <-- print @myId