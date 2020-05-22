// Summary Table
ArrayList<SummaryTable> summaryTable = new ArrayList<SummaryTable>();
for (String module : getAllModules(rawResult)) {
    int modPassed = getModulePassFailCount(rawResult, module).get(GlobalUtil.reportLabelPassed);
    int modFailed = getModulePassFailCount(rawResult, module).get(GlobalUtil.reportLabelFailed);

    summaryTable.add(new SummaryTable(
            getSummaryData(module, Integer.toString(modPassed), Integer.toString(modFailed))));
    root.put("summaryTable", summaryTable);
}