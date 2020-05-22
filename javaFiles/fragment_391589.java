List<Object> list = new ArrayList<Object>();

list.add(new String("Hello World"));
list.add(new Integer(1));
list.add(new Long(1l));

for (Object obj: list) {
    if (obj instanceof String){
        sqlPreparedStatement.setString((String) obj);
    } else if (obj instanceof Integer) {
        sqlPreparedStatement.setInt((Integer) obj);
    } else if (obj instanceof Long) {
        sqlPreparedStatement.setLong((Long) obj);
    }
}