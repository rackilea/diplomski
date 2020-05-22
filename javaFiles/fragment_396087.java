Connection connection = DriverManager.getConnection(url, user, pass);
CallableStatement cs = connection.prepareCall("{call DMG.Getstudentids(?,?)}");
cs.setFloat(1, 12342343);
cs.registerOutParameter(2, OracleTypes.CURSOR);
cs.executeQuery();
ResultSet resultSet=cs.getObject(1);
List<Integer> result = new ArrayList<Integer>();
while(resultSet.next()){
 result.add(resultSet.getInt(STUDENT_ID));
}