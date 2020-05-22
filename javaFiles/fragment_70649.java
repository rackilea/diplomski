CallableStatement callStmt = c.prepareCall("{call myFunc(?, ?, ?)}");
callStmt.setString(1, "1");
callStmt.setString(2, "2");
callStmt.setString(3, "3");
callStmt.execute();
callStmt.close();