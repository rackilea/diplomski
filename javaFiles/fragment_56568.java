//A function to put a value in temporary table
public void addValueToTmp(Connection conn, String value)  throws NamingException, SQLException {
  CallableStatement cs = conn.prepareCall("{call plsql_function_put_value_in_tmp(?)}");
  ....... other code .......
  ....... other code .......
  ....... other code .......
}

//A function to do something whit a data in temporary table
public void doAllWork(Connection conn)  throws NamingException, SQLException {
  CallableStatement cs = conn.prepareCall("{call plsql_function_do_something_whith_tmp}");
  ....... other code .......
  ....... other code .......
  ....... other code .......
}


public void mainFunction() throws NamingException, SQLException {
  ....... other code .......
  //Get connection
  Connection conn = anyFunctionToGetConnection();
  //Fill temporary table
  addValueToTmp(conn, value1);
  addValueToTmp(conn, value2);
  addValueToTmp(conn, value3);
  //Do something whith data
  doAllWork(conn);
  //Commit
  conn.commit;
  ....... other code .......
}