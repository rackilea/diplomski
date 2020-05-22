public boolean editSocre(String field, String newValue) {

... 

updateSql = "update score set "+field+" = ? where emp_id = ?";

pstmt3 = conn.prepareStatement(updateSql);

pstmt3.setString(1, newValue);

pstmt3.setString(2, userid);          

int row = pstmt3.executeUpdate();

if (row <= 0) {

  return result;

}