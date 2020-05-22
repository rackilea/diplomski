StringBuilder query = new StringBuilder("select t.id, t.one, t.two from Test t "); 
if (StringUtils.isNotEmpty(s)) { 
    query.append(" where t.one like :one "); 
} 
query.append(" order by t.id");
TypedQuery<Object[]> query = connection.createQuery(query.toString());