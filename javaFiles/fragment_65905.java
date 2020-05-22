ps = holder.get(cql);
if (ps == null) {
  ps = session.prepare(cql);
  PreparedStatement old = holder.putIfAbsent(cql, ps);
  if (old!=null)
    ps=old;
}