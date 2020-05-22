DocumentInstance documentInstance = null;  // I let you handle openDocument
ReportStructure structure = documentInstance.getStructure();
ReportContainer firstReport = (ReportContainer) structure.getReportElement(0);
if (firstReport.hasFilter()) {
    FilterContainer filterContainer = firstReport.getFilter();
    // Now you have the filters tree
}