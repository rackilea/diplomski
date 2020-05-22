CallableStatement callableStatement;

try {  
  callableStatement = cc.prepareCall("{call stored_proc(?,?,?,?,?)}");

  callableStatement.setString(1, "1");//Parameter #1
  callableStatement.setString(2, "ET");////Parameter #2
  callableStatement.setString(3, "|s|");// //Parameter #3
  callableStatement.registerOutParameter(4, Types.INTEGER); //Output # 1
  callableStatement.registerOutParameter(5, Types.VARCHAR); //Output # 2
  callableStatement.execute();

  Integer outputValue = callableStatement.getInt(4);
  String outputValue1 = callableStatement.getString(5);
}