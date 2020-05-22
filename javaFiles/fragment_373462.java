JasperReportBuilder report = report()
    .setTemplate(Templates.reportTemplate)
    .columns(
       col.column("Item", "item", type.stringType()),
       col.column("Quantity", "quantity", type.integerType()),
       col.column("Unit price", "unitPrice", type.bigDecimalType()))
    .title(Templates.createTitleComponent("CollectionDatasource"))
    .detailFooter(cmp.line())
    .pageFooter(Templates.footerComponent)
    .noData(Templates.createTitleComponent("NoData"), cmp.text("There is no data"))
    .setDataSource(c); // we are created design, set styles and datasource and so on for our builder

report.toPdf(new FileOutputStream("report4.pdf"));  // we are using the valid builder prepared at previous step