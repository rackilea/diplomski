enter code here
String file = "filename_";



// display time and date using toString()
Date date = new Date(System.currentTimeMillis());

 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
String dateString = formatter.format(date);

JasperExportManager.exportReportToPdfFile(jp,reportDest+file+dateString+".pdf");