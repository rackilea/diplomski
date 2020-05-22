private List<List<TableBean>> results = null;

public List<List<TableBean>> getResults() {

    if(results == null) {
        results = new ArrayList<List<TableBean>>();
        results.add(new TableBean("id"));
        results.add(new TableBean("name"));
        System.out.println("results.size = "+results.size());
        System.out.println("results.0 = "+results.get(0).getColumnName());
    }
    return results;
}