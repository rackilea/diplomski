JdbcTemplate jdbcTemplateObject;
@Autowired
public StudentDaoImp(DataSource dataSource)
{
this.dataSource = dataSource;
jdbcTemplateObject = new JdbcTemplate(this.dataSource); 
}