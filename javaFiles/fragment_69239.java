String query =   "select STD_NAME from " + TBName;
    try (Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            String studentName = rs.getString("STD_NAME");
            System.out.println(studentName + "\t");
        }
    } // Closes rs and stmt even with exceptions.