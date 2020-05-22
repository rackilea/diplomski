public class AbstractRepository<T extends AbstractEntity> {

    protected final Class<T> entityClazz;

    protected AbstractRepository() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        this.entityClazz = (Class<T>) paramType.getActualTypeArguments[0];
        // TODO exception handling
    }

    public List<T> list(String sql) { // retrieveEntities => very long name
        List<T> ret = new ArrayList<>();

        String query = "SELECT " + getColumnsForSelectStatement() + " FROM " + getTableName() + " WHERE " + sql;

        try (Connection conn = DatabaseUtil.createDatabaseConnection();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query)) {
            while (rs.next()) {
                T entity = factoryFromResultSet(rs);
                ret.add(entity);
            }
        } catch (SQLException sqle) {
            Debug.logSqlException(query, sqle);
        }

        return ret;
    }

    protected T factoryFromResultSet(ResultSet rs) {
        // Create new entity instance by reflection
        T entity = clazz.getConstructor().newInstance();

        // TODO exception handling 
        // Fill entity with result set data

        return entity;
    }
}