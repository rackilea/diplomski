String procedure = "{? = call CREATE_A_PERSON (?)}";
CallableStatement statement = conn.prepareCall(procedure);
statement.registerOutParameter(1, java.sql.Types.STRUCT, "UDO_PERSON");
statement.setString(2, "YOURE NAME");
statement.execute();
...