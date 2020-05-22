SQLQuery query = session.createSQLQuery("SELECT param1, param2 from table_name where ..);
List<Object[]> list = (List<Object[]>)query.list();//Object[] objs = (Object[])query.uniqueResult()
for (Iterator<Object[]> iterator = list.iterator(); iterator.hasNext();) {
    Object[] e = iterator.next();
    String param1 = (String)e[0];//case object type to another by youself...
}