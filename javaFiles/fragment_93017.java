public class GenericDAOJDBCImpl<T, K extends Serializable> implements GenericDAO<T, K extends Serializable> {
    private String db_url;

    private Connection;
    private PreparedStatement insert;
    // etc.
}