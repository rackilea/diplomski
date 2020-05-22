@Autowired
private JdbcTemplate JdbcTemplate;

public String getUUID(){
    UUID uuid = (UUID)jdbcTemplate.queryForObject("select UUID()", UUID.class);
    return uuid.toString();
}