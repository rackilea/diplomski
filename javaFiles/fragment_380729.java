TableModel model = new TableModelImp(); // TableModel implementation here
JTable table = new JTable(model);    
...
Map params = new HashMap();
...
JRDataSource dataSource = new JRTableModelDataSource(table.getModel());
JasperPrint print = JasperFillManager.fillReport("pathToYourReport.jasper", params, dataSource);
JasperViewer.viewReport(print, true); // true == Exit on Close