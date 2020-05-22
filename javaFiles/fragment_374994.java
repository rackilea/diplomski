public interface Report {
    void generateFile();
    boolean supports(ReportType type);
}

public class ExcelReport extends Report {
    publiv boolean support(ReportType type) {
        return type == ReportType.EXCEL;
    }
    //...
}

@Service
public class ReportFactory {

    @Resource
    private List<Report> reports;

    public Report forType(ReportType type) {
        for(Report report: reports) {
            if(report.supports(type)) {
                return report;
            }
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }
}