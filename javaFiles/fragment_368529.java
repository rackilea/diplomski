private static final ConcurrentHashMap<String, PreparedStatement> holder = new ConcurrentHashMap<>();

  public BoundStatement getStatement(String cql) {
    Session session = TestUtils.getInstance().getSession();
    PreparedStatement ps = holder.get(cql);
    if(ps == null) { // If "ps" is already present in cache, then we don't have to synchronize and make threads wait.

         if (holder.putIfAbsent(cql, session.prepare(cql)) != null) {
            // Someone else got there before, handle
         }
    }
    return ps.bind();
  }