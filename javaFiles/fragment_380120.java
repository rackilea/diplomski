String sql = "INSERT INTO user_info (user_id, password, firstname, lastname, emailid, age) " +
    "VALUES (?, ?, ?, ?, ?, ?)";

try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_info", "root", "nerdswonka");
    PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, userid);
        ps.setString(2, Arrays.toString(pass));
        ps.setString(3, firstname);
        ps.setString(4, surname);
        ps.setString(5, email);
        ps.setInt(6, age);

        int row = ps.executeUpdate();
        System.out.println(row); // rows inserted (should be 1)

    }
    catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}