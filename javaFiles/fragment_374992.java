public enum ReportType {EXCEL, CSV};

@Service
public class ReportFactory {

    @Resource
    private ExcelReport excelReport;

    @Resource
    private CSVReport csvReport

    public Report forType(ReportType type) {
        switch(type) {
            case EXCEL: return excelReport;
            case CSV: return csvReport;
            default:
                throw new IllegalArgumentException(type);
        }
    }
}