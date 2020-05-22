private static void test (int rows, int columns) throws Exception {
    // POI apparently can't create a document from scratch,
    // so we need an existing empty dummy document
    POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("empty.doc"));
    HWPFDocument doc = new HWPFDocument(fs);

    Range range = doc.getRange();
    Table table = range.insertBefore(new TableProperties(columns), rows);

    for (int rowIdx=0; rowIdx<table.numRows(); rowIdx++) {
        TableRow row = table.getRow(rowIdx);
        System.out.println("row "+rowIdx);
        for (int colIdx=0; colIdx<row.numCells(); colIdx++) {
            TableCell cell = row.getCell(colIdx);
            System.out.println("column "+colIdx+", num paragraphs "+cell.numParagraphs());
            try {
                Paragraph par = cell.getParagraph(0);
                par.insertBefore(""+(rowIdx*row.numCells()+colIdx));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }