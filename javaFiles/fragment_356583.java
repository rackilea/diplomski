List<String> strLst  = getJdbcTemplate().query(sql,new RowMapper {

  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return rs.getString(1);
  }

});

if ( strLst.isEmpty() ){
  return null;
}else if ( strLst.size() == 1 ) { // list contains exactly 1 element
  return strLst.get(0);
}else{  // list contains more than 1 elements
  //your wish, you can either throw the exception or return 1st element.    
}