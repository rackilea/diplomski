template.execute(new RedisCallback<Set<byte[]>>() {

  @Override
  public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
    return connection.zRangeByLex(key, Range.range().gte("aaaa").lte("aaaa"));
  }
});