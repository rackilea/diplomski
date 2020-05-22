@Value("#{entityToTableMap}")
private Map<String, String> entityToTableMap;    

@Value("#{entityToSearchFieldsMap}")
private Map<String, String> entityToSearchFieldsMap;

public List<T> blurrySearch(String keyword,String entityType) {
  String tableName = entityToTableMap.get(entityType);
  String searchField = entityToSearchFieldsMap.get(entityType);
  String sql ="select p from "+tableName+" p where p."+searchField+" LIKE :keyword order by p."+searchField
  ...
}