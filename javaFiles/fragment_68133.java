public class DataBaseReporterListener implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String s) {

        String componentName = suites.get(0).getParameter("component");
        String componentVersion = suites.get(0).getParameter("version");