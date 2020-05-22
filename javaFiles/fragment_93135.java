ResultSet rs = dmd.createStatement().executeQuery('select * from ta, tb')  // your join statement here
def rsmd = rs.getMetaData();
def colCount = rsmd.getColumnCount()

println "getColumnCount ${colCount}"

colCount.times {i ->
  println "---------------------------------"
  println "columnName ${rsmd.getColumnName(i+1)}"
  println "columnType ${rsmd.getColumnTypeName(i+1)}"
  println "Precision ${rsmd.getPrecision(i+1)}"
  println "Scale ${rsmd.getScale(i+1)}"
  println "isNullable ${rsmd.isNullable(i+1)}" 
  // Oracle extension
  println "isNCHAR ${rsmd.isNCHAR(i+1)}"  
  // print column value as String
  println rs.getString(i+1)
}