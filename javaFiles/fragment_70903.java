public class ReporterProcessor implements Processor {
    private List<Reporter> reporters;
    @Override
    public void process(final Exchange exchange) throws Exception {
        List<Object> aggregatedList = new ArrayList<>();
        for (final ReporterBean reporter : reporters) {
            aggregatedList.add(reporter.report(exchange));
        }
        exchange.getIn().setBody(aggregatedList);
    }
    public void setReporters(final List<Reporter> reporters) {
        this.reporters = reporters;
    }
}