JasperPrint jp = JasperFillManager.fillReport(report, params, dataSource);
for (Iterator<JRPrintPage> iterator = jp.getPages().iterator(); iterator.hasNext();) {
     JRPrintPage page = iterator.next();
     if (!iterator.hasNext() && page.getElements().isEmpty()) {
          iterator.remove();
     }
 }