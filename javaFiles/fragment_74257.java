public List<Message> getMesssages() throws SQLException {
    try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
         Statement statement = conn.createStatement()) {
        ResultSet result = statement.executeQuery("SELECT * FROM departments");
        List<Message> messages = new ArrayList<>();

        while (result.next()) {
            Message message = new Message();
            message.setDept_no(result.getString("dept_no"));
            message.setDept_name(result.getString("dept_name"));
            messages.add(message);
        }

        return messages;
    }
}