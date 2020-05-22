KeywordPerformanceReportRequest reportRequest = 
        new KeywordPerformanceReportRequest();

    // Specify the language of the report.
    reportRequest.setLanguage(ReportLanguage.English);

    // Specify the format of the report.
    reportRequest.setFormat(ReportFormat.Xml);
    reportRequest.setReturnOnlyCompleteData(false);
    reportRequest.setReportName("Keyword Report");
    reportRequest.setAggregation(ReportAggregation.Daily);

    reportRequest.setTime(.....);

    // Specify the scope of the report.
    AccountThroughAdGroupReportScope scope = 
        new AccountThroughAdGroupReportScope();
    scope.setAccountIds(ids);
    reportRequest.setScope(scope);