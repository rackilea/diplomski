private static Set<String> getReferencedWorkbooksXssf(XSSFWorkbook workbook) {
    Set<String> workbookNames = new HashSet<>();
    final List<ExternalLinksTable> externalLinksTable = workbook.getExternalLinksTable();
    for (ExternalLinksTable linksTable : externalLinksTable) {
        final String linkedFileName = linksTable.getLinkedFileName();
        workbookNames.add(linkedFileName);
    }

    return workbookNames;
}