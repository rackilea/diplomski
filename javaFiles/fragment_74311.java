public List search() {
  ...
  DataSource ds = (DriverManagerDataSource) ctx.getBean("dataSource");
  CataProc proc = new CataProc(ds,"getCatagories");
  Map results = proc.execute(params);
  List catagory = (List)results.get("catagories");
  ... 
}