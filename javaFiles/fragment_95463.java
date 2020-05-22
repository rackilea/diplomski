private Request buildRequestAddNoteCell(int startRow, int endRow, int startColumn, int endColumn, int sheetId, String note) {
    Request request = new Request();
    request.setRepeatCell(new RepeatCellRequest()
            .setCell(new CellData().setNote(note))
            .setRange(new GridRange()
                    .setSheetId(sheetId)
                    .setStartRowIndex(startRow)
                    .setEndRowIndex(endRow)
                    .setStartColumnIndex(startColumn)
                    .setEndColumnIndex(endColumn))
            .setFields("note")
            );
    return request;
}