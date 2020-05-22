public int createCompany(Company company) throws SQLException {
        jdbcTemplate.update(
                "INSERT INTO company (name) VALUES (?)",
                company.getName()
        );
        return jdbcTemplate.queryForInt( "select last_insert_id()" );
    }