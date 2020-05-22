public class CarrierGroupDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarrierGroupDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<Long, String> getAllCarrierGroups() {
        String sql = "select t.carrier_group_id, t.updated_by from  pv_carrier_group t where t.status = 'Q'";
        return jdbcTemplate.execute(sql, new CallableStatementCallback<Map<Long, String>>() {
            @Override
            public Map<Long, String> doInCallableStatement(CallableStatement cs)
                    throws SQLException, DataAccessException {
                ResultSet resultSet = cs.executeQuery();
                Map<Long, String> carrierGroups = new HashMap<>();
                while (resultSet.next()) {
                    carrierGroups.put(resultSet.getLong("carrier_group_id"), resultSet.getString("updated_by"));
                }
                return carrierGroups;
            }
        });
    }
}