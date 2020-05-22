@Repository
public class DomainsDao extends JdbcDaoSupport {

    @Autowired
    private MessageSourceAccessor msa;

    @Autowired
    public void setJT(JdbcTemplate jdbcTemplate) {
         setJdbcTemplate(jdbcTemplate);
    }

    public List<Domain> getInactiveDomains() {
        return getJdbcTemplate().query(msa.getMessage("sql.pass.domain.select_inactive"), new DomainRowMapper());
    }
    public int getDomainId(String name) {
        String sql = msa.getMessage("sql.pass.domain.select_by_name");
        Object[] args = new Object[] { name };
        return getJdbcTemplate().queryForObject(sql, args, Integer.class);
    }
}