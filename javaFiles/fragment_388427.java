public Map<Integer, List<String>> getResults(Object[] params)
{
  Map<Integer, List<String>> result = jdbcTemplate.query(sqlStr, new ResultExtractor(),
                                                         params);
  return result;
}

private final class ResultExtractor implements ResultSetExtractor<Map<Integer, List<String>>>
{
  @Override
  public Map<Integer, List<String>> extractData(ResultSet rs)
                                    throws SQLException, DataAccessException
  {
    Map<Integer, List<String>> resultMap = new HashMap<Integer, List<String>>();

    while (rs.next())
    {
      int id = rs.getInt("id");
      List<String> nameList = resultMap.get(id);
      if (nameList == null)
      {
        nameList = new ArrayList<String>();
        resultMap.put(id, nameList);
      }
      nameList.add(rs.getString("name"));
    }
    return resultMap;
  }

}