public enum Report {
    SALES("Sale Report", "select * from some_view"),
    PROFIT("Profit Report", "select * from some_other_view");

    final String reportName;
    final String sql;

    private Report(String reportName, String sql) {
        this.reportName = reportName;
        this.sql = sql;
    }

    public String getReportName() {
        return reportName;
    }

    public String getSql() {
        return sql;
    }
}