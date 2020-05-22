//...
  import javax.print.attribute.standard.Destination;
  //...

  JRExporter exporter = new JRPrintServiceExporter();          

  //--- Set print properties
  PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
  printRequestAttributeSet.add(MediaSizeName.ISO_A4);   

  //----------------------------------------------------     
  printRequestAttributeSet.add(new Destination(new java.net.URI("file:d:/output/report.ps")));
  //----------------------------------------------------     

  PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
  printServiceAttributeSet.add(new PrinterName("Xerox DocuPrint 100 EPS PS3", null)); 

  //--- Set print parameters      
  exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
  exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);      
  exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printServiceAttributeSet);      
  exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
  exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);      

  //--- Print the document
  try{
      exporter.exportReport();
  }
  catch(JRException e){
      e.printStackTrace();
  }