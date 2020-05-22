Object sqlParameters[] = {uuid};
return jdbcTemplate.query(sql, sqlParameters,
new ResultSetExtractor<List<String>>() {  
    @Override
    public List<String> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<String> emailList=new ArrayList<String>();  
        while (rs.next()) {
            emailList.add(rs.getString("email"));
        }
        return emailList;
    }});