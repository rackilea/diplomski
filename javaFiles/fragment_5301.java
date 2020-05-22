s.execute();  // perform the UPDATE
    try (ResultSet rs = s.getGeneratedKeys()) {
        while (rs.next()) {
            System.out.println(rs.getInt(1));  // print the "branch_id" value of the updated row
        }
    }