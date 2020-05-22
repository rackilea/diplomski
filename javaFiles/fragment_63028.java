public class ReportGenarator {

public static String OUT_PUT = "your_output_file_path/myreport.docx";
public static String REPORT = "your_report_path/myreport.jrxml";

public void genarateReport(String reportPath,
        Map<String, Object> map, Connection con) {
    try {

        JasperReport jr = JasperCompileManager.compileReport(
                ClassLoader.getSystemResourceAsStream(reportPath));
        JasperPrint jp = JasperFillManager.fillReport(jr, map, con);
        JRDocxExporter export = new JRDocxExporter();
    export.setExporterInput(new SimpleExporterInput(jp));
    export.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(OUT_PUT)));
    SimpleDocxReportConfiguration config = new SimpleDocxReportConfiguration();
    export.setConfiguration(config);
    export.exportReport();
    } catch (JRException ex) {
        ex.printStackTrace();   
    }
} }