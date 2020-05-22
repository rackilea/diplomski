String insertSql = "BEGIN INSERT INTO TEST (ID, NAME) VALUES (SEQ_TEST.NEXTVAL(), ?) RETURNING ID INTO ?; END;";
java.sql.CallableStatement stmt = conn.prepareCall(insertSql);
stmt.setString(1, "John Smith");
stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
stmt.execute();
int id = stmt.getInt(2);