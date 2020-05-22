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
        .setDataSource(c); // here is a first instance. It is initialized via builde. You should use instance for any actions
report().toPdf(new FileOutputStream("report4.pdf")); // the second instance. Just "blank" object, you are missed initializing via builder