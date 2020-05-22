public class YourDaoClass { 
  private final JdbcTemplate jdbcTemplate;
  private final ItemPreparedStatementCreatorFactory preparedStatementCreatorFactory;
  public YourDaoClass(ItemPreparedStatementCreatorFactory preparedStatementCreatorFactory, JdbcTemplate jdbcTemplate){
    this.preparedStatementCreatorFactory = preparedStatementCreatorFactory;
    this.jdbcTemplate = jdbcTemplate;
  }