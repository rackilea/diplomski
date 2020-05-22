courseId=Integer.parseInt(s.nextLine());

PreparedStatement st1 = (PreparedStatement) con.prepareStatement("   
   SELECT * FROM courses WHERE courseId=?");

st1.setInt(1,courseId);
ResultSet r = st1.executeQuery();