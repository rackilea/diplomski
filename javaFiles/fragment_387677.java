PreparedStatement pst2 = connection.prepareStatement("select * from course where course_code = ?");
pst2.setString(1, "SLIOP-P");  // this is an example; pass anything
ResultSet rs = pst2.executeQuery();
String courseCode = null;
if (rs.next()) {
     courseCode = rs.getString("course_code") + "-" + String.format("%03d", rs.getInt("id"));
}