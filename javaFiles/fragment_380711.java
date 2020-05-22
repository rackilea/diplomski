@Override
    public List<User> Search(String empID) {
        JdbcTemplate search = new JdbcTemplate(ds);
        return search.query("Select empID from user where empID = '?'",
        new UserRowMapper());
    }