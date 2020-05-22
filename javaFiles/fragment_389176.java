PreparedStatement pstmt = connection.prepareStatement(
      "select MyTable.COLOR from MyTable where MyTable.LENGTH=?");

pstmt.setInt(1, desiredLength);

ResultSet rs = pstmt.executeQuery();