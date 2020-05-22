public static void addProductToDB(String url, String title, String price) {
    MySQLiteDatasource datasource = new MySQLiteDatasource(this);
    datasource.open();
    datasource.insertProduct(url, title, price);
    datasource.close();
  }