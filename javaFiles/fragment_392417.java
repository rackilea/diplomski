BatchUpdateSpreadsheetRequest busReq = new BatchUpdateSpreadsheetRequest();
SortSpec ss = new SortSpec();
// ordering ASCENDING or DESCENDING
ss.setSortOrder("DESCENDING");
// the column number starting from 0
ss.setDimensionIndex(1);
SortRangeRequest srr = new SortRangeRequest();
srr.setSortSpecs(Arrays.asList(ss));
Request req = new Request();
req.setSortRange(srr);
busReq.setRequests(Arrays.asList(req));
// mService is a instance of com.google.api.services.sheets.v4.Sheets
this.mService.spreadsheets().batchUpdate(spreadsheetId, busReq).execute();