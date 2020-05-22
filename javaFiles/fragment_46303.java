DataSourceReader dsr1 = new FileSource("your csv file path");
String[] columnsArray // create array of column names you want to display 
CSVDataSource ds1 = new CSVDataSource(dsr1,columnsArray);
TableView tableView = new TableView();
tableView.setItems(ds1.getData());
tableView.getColumns().addAll(ds1.getColumns());