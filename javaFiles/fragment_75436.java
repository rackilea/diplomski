PreparedStatement ps = conn.prepareStatement(
    "INSERT INTO record SELECT NULL, idNum, ?, ?, ?, ? FROM students");
ps.setString(1, descript);
ps.setInt   (2, value);
ps.setString(3, user.getText());
ps.setString(4, timeStamp);
ps.execute();