import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.*;
public class RunReport {    
    public static void runReport() throws Exception {        
        IReportEngine engine = null;
        EngineConfig config = new EngineConfig();        
        config.setEngineHome("C:/Projects/My Works Related/BIRT/BIRT_2_6_1/birt-runtime-4_2_1/birt-runtime-4_2_1/ReportEngine");
         Platform.startup(config);        
        IReportEngineFactory factory = (IReportEngineFactory) Platform
                .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);        
        engine = factory.createReportEngine(config);
        IReportRunnable design = engine.openReportDesign("C:/Projects/My Works Related/Backup From My System and Proton/Backup from Proton/SEM/rk/rk/birt-runtime-Eclipse _workspace2_6_2/eclipse-reporting-helios-SR2-win32/workSpace/ExecuteCSVReport/reports/csvReport2.rptdesign");
        IRunAndRenderTask task = engine.createRunAndRenderTask(design);     
        EXCELRenderOption excelOptions = new EXCELRenderOption();
        excelOptions.setOutputFormat("xls");
        excelOptions.setOutputFileName("C:/Projects/My Works Related/Backup From My System and Proton/Backup from Proton/SEM/rk/rk/birt-runtime-Eclipse _workspace2_6_2/eclipse-reporting-helios-SR2-win32/workSpace/ExecuteCSVReport/reports/native.xls");
        excelOptions.setEmitterID( "uk.co.spudsoft.birt.emitters.excel.XlsEmitter" );
        task.setRenderOption(excelOptions);     
        task.run();
        task.close();        
        Platform.shutdown();
        System.out.println("Report Generated Sucessfully!!");
    }
    public static void main(String[] args) {
        try {
            runReport();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}