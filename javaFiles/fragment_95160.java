@FunctionalInterface
interface RSExtractor<T,U,R> {
    R apply(T t, U u) throws SQLException;
}
private Map<Class<?>, RSExtractor<ResultSet, Triple<Integer, Object, Class<?>>, Object>> getters = new HashMap<>();
{
    getters.put(String.class, (rs, param) -> rs.getString(param.getLeft()));
    getters.put(Integer.class, (rs, param) -> rs.getInt(param.getLeft()));
}

public List<Object> get(ResultSet rs) throws SQLException {
    List<Object> results = new ArrayList<>();
    for (Triple<Integer, Object, Class<?>> param : paramList) {
        results.add(getters.get(param.getRight()).apply(rs, param));
    }
    return results;
}