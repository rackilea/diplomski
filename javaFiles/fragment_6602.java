public void createPdf(String dest) throws IOException, DocumentException {
    Document document = new Document(PageSize.A4.rotate());
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();
    PdfPTable table = new PdfPTable(9);
    table.setWidthPercentage(100);
    table.setWidths(new int[]{4, 1, 3, 4, 3, 3, 3, 3, 1});
    BufferedReader br = new BufferedReader(new FileReader(DATA));
    String line = br.readLine();
    process(table, line, new Font(FontFamily.HELVETICA, 16, Font.BOLD));
    table.setHeaderRows(1);
    while ((line = br.readLine()) != null) {
        process(table, line, new Font(FontFamily.HELVETICA, 12));
    }
    br.close();
    document.add(table);
    document.close();
}

public void process(PdfPTable table, String line, Font font) {
    StringTokenizer tokenizer = new StringTokenizer(line, ";");
    while (tokenizer.hasMoreTokens()) {
        table.addCell(new Phrase(tokenizer.nextToken(), font));
    }
}