public class ReportGen {
private static ReportDesignHandle reportDesignHandle;
private static ElementFactory elementFactory;
private static ReportDesignHandle reportDesignHandle1;

public static void main(String[] args) {
    executeReport();
}

public static void executeReport() {

    IReportEngine engine = null;
    EngineConfig config = null;

    try {
        config = new EngineConfig();
        config.setBIRTHome("/home/vineeth/Softwares/birt-runtime-2_6_2/ReportEngine");
        config.setLogConfig("/home/vineeth/Softwares", Level.FINEST);
        Platform.startup(config);
        IReportEngineFactory factory = (IReportEngineFactory) Platform
                .createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
        engine = factory.createReportEngine(config);

        IReportRunnable design = null;
        //Open the report design
        design = engine.openReportDesign("/home/vineeth/cash_flow_summary.rptdesign");
        SessionHandle sessionHandle = DesignEngine.newSession(null);
        reportDesignHandle = sessionHandle.createDesign();
        elementFactory = reportDesignHandle.getElementFactory();
        reportDesignHandle1 = (ReportDesignHandle) design.getDesignHandle();
        DesignElementHandle cashflow = reportDesignHandle1.findElement("cashflow");
        DesignElementHandle designElementHandle = reportDesignHandle1.getBody().get(0);
        if (designElementHandle instanceof ExtendedItemHandle) {
            ExtendedItemHandle itemHandle = (ExtendedItemHandle) designElementHandle;
            ExtendedItem item = (ExtendedItem) itemHandle.getElement();

            ExtendedItem newItem1 = (ExtendedItem) item.doClone(CopyForPastePolicy.getInstance());
            newItem1.setName("cf1");
            newItem1.setProperty(DesignChoiceConstants.CHOICE_PAGE_BREAK_AFTER, DesignChoiceConstants.PAGE_BREAK_AFTER_ALWAYS);
            ExtendedItemHandle newItemHandle1 = new ExtendedItemHandle(reportDesignHandle.getModule(), newItem1);
            reportDesignHandle.getBody().add(newItemHandle1);

            ExtendedItem newItem2 = (ExtendedItem) item.doClone(CopyForPastePolicy.getInstance());
            newItem2.setName("cf2");
            newItem2.setProperty(DesignChoiceConstants.CHOICE_PAGE_BREAK_AFTER, DesignChoiceConstants.PAGE_BREAK_AFTER_ALWAYS);
            ExtendedItemHandle newItemHandle2 = new ExtendedItemHandle(reportDesignHandle.getModule(), newItem2);
            reportDesignHandle.getBody().add(newItemHandle2);

            ExtendedItem newItem3 = (ExtendedItem) item.doClone(CopyForPastePolicy.getInstance());
            newItem3.setName("cf3");
            newItem3.setProperty(DesignChoiceConstants.CHOICE_PAGE_BREAK_AFTER, DesignChoiceConstants.PAGE_BREAK_AFTER_ALWAYS);
            ExtendedItemHandle newItemHandle3 = new ExtendedItemHandle(reportDesignHandle.getModule(), newItem3);
            reportDesignHandle.getBody().add(newItemHandle3);

            DataSourceHandle dataSourceHandle = (DataSourceHandle) reportDesignHandle1.getDataSources().get(0);
            DataSource ds = (DataSource) dataSourceHandle.copy();
            DataSourceHandle newDSHandle = null;
            if (ds instanceof OdaDataSource) {
                newDSHandle = new OdaDataSourceHandle(reportDesignHandle.getModule(), ds);
            }
            reportDesignHandle.getDataSources().add(newDSHandle);


            DataSetHandle dataSetHandle = (DataSetHandle) reportDesignHandle1.getDataSets().get(0);
            OdaDataSet copyDataSetHandle = (OdaDataSet) dataSetHandle.copy();
            DataSetHandle copyDSHandle = new OdaDataSetHandle(reportDesignHandle.getModule(), copyDataSetHandle);
            reportDesignHandle.getDataSets().add(copyDSHandle);
        }
        //reportDesignHandle.getBody().add(reportDesignHandle1.getBody().get(0));
        //reportDesignHandle.getBody().add(reportDesignHandle1.getBody().get(0));
        IReportRunnable newDesign = engine.openReportDesign(reportDesignHandle);
        IRunAndRenderTask task = engine.createRunAndRenderTask(newDesign);
        HTMLRenderOption options = new HTMLRenderOption();
        options.setOutputFileName("/home/vineeth/Softwares/out.html");
        options.setOutputFormat("html");
        task.setRenderOption(options);
        task.run();
        task.close();
        engine.destroy();
    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        Platform.shutdown();
    }
}