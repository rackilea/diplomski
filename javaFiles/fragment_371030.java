session.doWork(new Work() {
  public void execute(Connection connection) throws SQLException {
    CallableStatement call = connection.prepareCall("{ ? = call MYSCHEMA.MYFUNC(?,?) }");
    call.registerOutParameter( 1, Types.INTEGER ); // or whatever it is
    call.setLong(2, id);
    call.setLong(3, transId);
    call.execute();
    int result = call.getInt(1); // propagate this back to enclosing class
  }
});