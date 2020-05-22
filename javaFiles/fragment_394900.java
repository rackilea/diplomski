@Repository
public class DAOImpl implements DAO {
    private static final Logger logger = Logger.getLogger(HunterDAOImpl.class) ;

    private final JdbcTemplate jdbc;

    public DAOImpl(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
    }

    @Override
    public Integer insert1() throws SQLException { 
        return jdbc.update(SQLQuery);
    }

     @Override
    public Integer insert2() throws SQLException {
        return jdbc.update(SQLQuery);
    }

}