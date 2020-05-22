Query callStoredProcedure_MYSQL = session.createSQLQuery("CALL SP_MYSQL_HIBERNATE (:param1, :param2, :param3)");
callStoredProcedure_MYSQL.setInteger("param1", 10);
callStoredProcedure_MYSQL.setInteger("param2", 10);
callStoredProcedure_MYSQL.setString("param3", "test");*/

/* callStoredProcedure_MYSQL.list() will execute stored procedure and return the value */
List customResult = callStoredProcedure_MYSQL.list();
if (customResult != null && !customResult.isEmpty()) {
 Object[] obj = customResult.get(0);
 System.out.println(obj[0]);
 System.out.println(obj[1]);            
}