public static List<Object[]> formatResult(ResultSet rs) {
    List<Object[]> resultList = new ArrayList<Object[]>();
    try {
        while(rs.next()) {
            Object[] array = new Object[rs.getMetaData().getColumnCount()];
            for (int i = 0; i < array.length; i++) {
                array[i] = rs.getObject(i+1);
            }
            resultList.add(array);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return resultList;
}