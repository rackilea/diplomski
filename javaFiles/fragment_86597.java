@Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> blurrySearch(String keyword,String entityType) {
      String tableName = entityToTableMap.get(entityType);
      String searchField = entityToSearchFieldsMap.get(entityType);
      String sql ="select p from "+tableName+" p where p."+searchField+" LIKE ? order by p."+searchField
      return jdbcTemplate.queryForList(sql, new String[]{"%"+keyword+"%"});
    }