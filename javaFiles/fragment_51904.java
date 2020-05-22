@Autowired
ServletContext context;

@Async
@Scheduled(cron = "0 0 16 * * ?")
public void createReport()
{
    // argJasperPath = /WEB-INF/jasperFiles/myreport.jasper
    JasperPrint jasperPrint = JasperFillManager.fillReport(context.getRealPath(argJasperPath), argReportParams, argDataSource);
    JasperExportManager.exportReportToPdfFile(jasperPrint, argOutputPath);
}