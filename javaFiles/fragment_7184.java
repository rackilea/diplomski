@Autowired
private JdbcTemplate temp;

@RequestMapping("/foo")
public List<Foo> connectAndRetrieve() {
    String sql = "SELECT * FROM Foo";
    return temp.query(sql, new BeanPropertyRowMapper(Foo.class));
}