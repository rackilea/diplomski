public class MySuiteHTMLReporter extends SuiteHTMLReporter {
  @Override
  void generateReport(java.util.List<XmlSuite> xmlSuites,
                    java.util.List<ISuite> suites,
                    java.lang.String outputDirectory) {
    String timestamp = ...
    super.generateReport(xmlSuites, suites, outputDirectory + "-" + timestamp);
  }
}