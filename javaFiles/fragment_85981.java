public List<List<Object[]>> execute(String sqls, Object valueObject) throws Exception {
    String[] queries = sqls.split(";");
    List<List<Object[]>> result = new ArrayList<>();

    for(int i=0; i<queries.length; i++) {
        result.add(this.select(queries[i], valueObject));
    }
    return result;
}