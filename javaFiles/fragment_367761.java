public class JdbcPropertiesFactoryBean
    extends AbstractFactoryBean<Properties>{

    @Required
    public void setJdbcTemplate(final JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    private JdbcTemplate jdbcTemplate;

    @Required
    public void setTableName(final String tableName){
        this.tableName = tableName;
    }
    private String tableName;

    @Required
    public void setKeyColumn(final String keyColumn){
        this.keyColumn = keyColumn;
    }
    private String keyColumn;

    @Required
    public void setValueColumn(final String valueColumn){
        this.valueColumn = valueColumn;
    }
    private String valueColumn;

    @Override
    public Class<?> getObjectType(){
        return Properties.class;
    }

    @Override
    protected Properties createInstance() throws Exception{
        final Properties props = new Properties();
        jdbcTemplate.query("Select " + keyColumn + ", " + valueColumn
            + " from " + tableName, new RowCallbackHandler(){

            @Override
            public void processRow(final ResultSet rs) throws SQLException{
                props.put(rs.getString(1), rs.getString(2));
            }

        });
        return props;
    }
}