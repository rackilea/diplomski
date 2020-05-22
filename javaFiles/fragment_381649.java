public static void reportGenerator(String reportType, List<String> jrxmlFileNames, 
Datasource dataSource , String SwapFile)
{

    JRConcurrentSwapFile swapFile = new JRConcurrentSwapFile(SwapFile, 102400 , 10);
    JRAbstractLRUVirtualizer virtualizer = new JRSwapFileVirtualizer(1000, swapFile, true);
    Map<String, JRAbstractLRUVirtualizer> parameters = new HashMap<String, JRAbstractLRUVirtualizer>();
    parameters.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);
    try
    {
        if (reportType.equalsIgnoreCase("PDF"))
        {

            try
            {
                JasperReport jreport1 = JasperCompileManager.compileReport(ReportGenerator.class.getResourceAsStream(jrxmlFileNames.get(0)));
                JasperPrint jprint1 = JasperFillManager.fillReport(jreport1, parameters, new JRBeanCollectionDataSource(dataSource.getDataSourceFor1()));

                JasperReport jreport2 = JasperCompileManager.compileReport(ReportGenerator.class.getResourceAsStream(jrxmlFileNames.get(1)));
                JasperPrint jprint2 = JasperFillManager.fillReport(jreport2, parameters, new JRBeanCollectionDataSource(dataSource.getDataSourceFor2()));


                List<JasperPrint> jprintlist = new ArrayList<JasperPrint>();

                jprintlist.add(jprint1);
                jprintlist.add(jprint2);


                String fileName="TESTReport.pdf";
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, jprintlist);

                exporter.setParameter(JRPdfExporterParameter.OUTPUT_FILE_NAME, fileName);

                exporter.exportReport();

                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            swapFile.dispose();

        }
    catch(Exception e)
    {
     e.printStackTrace();
    }

}