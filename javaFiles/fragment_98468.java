RowRecord row = sheet.getNextRow();
  boolean rowRecordsAlreadyPresent = row != null;


207                 if (hrow == null) {
208                     // Some tools (like Perl module Spreadsheet::WriteExcel - bug 41187) skip the RowRecords
209                     // Excel, OpenOffice.org and GoogleDocs are all OK with this, so POI should be too.
210                     if (rowRecordsAlreadyPresent) {
211                         // if at least one row record is present, all should be present.
212                         throw new RuntimeException("Unexpected missing row when some rows already present");
213                     }