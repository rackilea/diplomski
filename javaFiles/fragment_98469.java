if (hrow == null) {
        /* we removed this check, see bug 47245 for the discussion around this
        // Some tools (like Perl module Spreadsheet::WriteExcel - bug 41187) skip the RowRecords
        // Excel, OpenOffice.org and GoogleDocs are all OK with this, so POI should be too.
        if (rowRecordsAlreadyPresent) {
            // if at least one row record is present, all should be present.
            throw new RuntimeException("Unexpected missing row when some rows already present");
        }*/

        // create the row record on the fly now.
        RowRecord rowRec = new RowRecord(cval.getRow());
        sheet.addRow(rowRec);
        hrow = createRowFromRecord(rowRec);
    }