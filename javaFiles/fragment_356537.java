public static CellRangeAddress getMergedRegion(Cell cell) {
    Sheet sheet = cell.getSheet();
    for (CellRangeAddress range : sheet.getMergedRegions()) {
        if (range.isInRange(cell.getRowIndex(), cell.getColumnIndex())) {
            return range;
        }
    }
    return null;
}