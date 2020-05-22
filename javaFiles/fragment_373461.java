report()
        .setTemplate(Templates.reportTemplate)
        .columns(
           col.column("Item", "item", type.stringType()),
           col.column("Quantity", "quantity", type.integerType()),
           col.column("Unit price", "unitPrice", type.bigDecimalType()))
        .title(Templates.createTitleComponent("CollectionDatasource"))
        .detailFooter(cmp.line())
        .pageFooter(Templates.footerComponent)
        .noData(Templates.createTitleComponent("NoData"), cmp.text("There is no data"))
        .setDataSource(c)
        .toPdf(new FileOutputStream("report4.pdf")); // we are not breaking the chain