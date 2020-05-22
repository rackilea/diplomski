class MyClass {
   private MyResource res = null;

   private MyResource getMyResource() {
      if (res == null) res = new MyResource(getConnection());
      return res;
   }

   private Connection getConnection() {
      ....
      con = dataSource.getConnection();
      ....
      return con;
   }
}