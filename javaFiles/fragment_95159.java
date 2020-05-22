@FunctionalInterface
interface PSConsumer<T,U> {
    void accept(T t, U u) throws SQLException;
}

private Map<Class<?>, PSConsumer<PreparedStatement, Triple<Integer, Object, Class<?>>>> setters = new HashMap<>();
{
    setters.put(String.class, (st, param) -> st.setString(param.getLeft(), (String) param.getMiddle()));
    setters.put(Integer.class, (st, param) -> st.setInt(param.getLeft(), (Integer) param.getMiddle()));
    // add here code for all the classes that you support
}

for (Triple<Integer, Object, Class<?>> param : paramList) {
    // this will throw an NPE if param.getMiddle() returns null or it's class is not in the map:
    setters.get(param.getMiddle().getClass()).accept(st, param);
}