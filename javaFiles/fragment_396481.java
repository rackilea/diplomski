RowMapper<Person> rowMapper = (rs, rowNum) -> {
    Person p = new Person();
    p.setName(rs.getString("personName"));
    p.setAddress(rs.getString("address"));
    p.setAge(rs.getInt("age"));
    return p;
};