public void setComment(String text, Cell cell) {
    final Map<Sheet, HSSFPatriarch> drawingPatriarches = new HashMap<Sheet, HSSFPatriarch>();

    CreationHelper createHelper = cell.getSheet().getWorkbook().getCreationHelper();
    HSSFSheet sheet = (HSSFSheet) cell.getSheet();
    HSSFPatriarch drawingPatriarch = drawingPatriarches.get(sheet);
    if (drawingPatriarch == null) {
        drawingPatriarch = sheet.createDrawingPatriarch();
        drawingPatriarches.put(sheet, drawingPatriarch);
    }

    Comment comment = drawingPatriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
    comment.setString(createHelper.createRichTextString(text));
    cell.setCellComment(comment);
}