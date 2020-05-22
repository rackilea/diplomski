public class ReportHeaderService {

    private Map<ReportType, ReportHeader> reportHeaderMap;

    public void generateHeader(ReportType type){
        ReportHeader reportHeader = reportHeaderMap.get(type);
        if (reportHeader != null) {
            reportHeader.createHeader();
        }
    }
}