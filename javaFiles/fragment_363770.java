enum ReportType {

    PNL_REPORT("11", "pnlreport"),
    BALANCE_SHEET("20", "balance");

    private final String reportId;
    private final String name;

    ReportType(String reportId, String name) {
        this.reportId = reportId;
        this.name = name;
    }

    static ReportType fromName(String name) {
        return Arrays.stream(values())
            .filter(reportType -> reportType.name.equals(name))
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    public String getId() {
        return reportId;
    }
}

class ReportFile {

    private static final Pattern WINDOWS_REGEX =
        Pattern.compile(".+\\\\(Client[^\\\\]+)\\\\COB([^\\\\]+)\\\\([^\\\\.]+).([^\\\\.]+)");

    private static final Pattern UNIX_REGEX =  
        Pattern.compile(".+/(Client[^/]+)/COB([^/]+)/([^/.]+).([^/.]+)");

    private final File file;

    public ReportFile(File file) {
        this.file = file;
    }

    Report toReport() {
        String filePath = file.getPath();
        Matcher matcher = WINDOWS_REGEX.matcher(filePath);

        if (!matcher.find()) {
            throw new RuntimeException("Invalid path for report: " + filePath);
        }

        String client = matcher.group(1);
        Date cobDate;
        try {
            LocalDate cobLocalDate =
                LocalDate.parse(matcher.group(2), DateTimeFormatter.ofPattern("dMMMy").withLocale(Locale.US));
            cobDate = Date.from(cobLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String reportName = matcher.group(3);
        String id = ReportType.fromName(matcher.group(3)).getId();
        String extension = matcher.group(4);

        return new Report(
            id, reportName, client, extension, cobDate, filePath
        );
    }
}

class Ex {
    public static void main(String[] args) {
        List<Report> reportDeliverables = new ArrayList<>();

        List<File> filesToSend = ImmutableList.of(
            new File("C:\\pathToReports\\ClientABC\\COB28Sep2017\\pnlreport.pdf")
        );

        System.out.println(filesToSend.stream()
            .map(ReportFile::new)
            .map(ReportFile::toReport)
            .collect(Collectors.toList()));
    }
}