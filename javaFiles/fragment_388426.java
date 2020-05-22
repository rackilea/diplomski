public List<MessageSummary> getMessages(Object[] params)
{
  // mList is filled with objects created in MessageRowMapper,
  // so the length of the list equal to the number of rows in the ResultSet
  List<MessageSummary> mList = jdbcTemplate.query(sqlStr, new MessageRowMapper(),
                                                  params);
  return mList;
}

private final class MessageRowMapper implements RowMapper<MessageSummary>
{
  @Override
  public MessageSummary mapRow(ResultSet rs, int i) throws SQLException
  {
    MessageSummary ms = new MessageSummary();

    ms.setId(rs.getInt("id"));
    ms.setMessage(rs.getString("message"));

    return ms;
  }
}