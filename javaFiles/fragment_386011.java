try (Connection connection = getConnection(); 
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery(sql)) {
    StringBuffer sb = new StringBuffer();
    List users = new ArrayList<>();
    while (rs.next()) {
        int id = rs.getInt("id");
        String first = rs.getString("first");
        String last = rs.getString("last");
        String email = rs.getString("email");
        String company = rs.getString("company");
        String city = rs.getString("city");
        users.add(new User(id,first, last, email, company, city));
    }
    model.addAttribute("users", users);
    return "user";
}