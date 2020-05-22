public void parse(String filename) throws IOException {
    PdfReader reader = new PdfReader(filename);
    Rectangle rect = new Rectangle(36, 750, 559, 806);
    RenderFilter regionFilter = new RegionTextRenderFilter(rect);
    FontRenderFilter fontFilter = new FontRenderFilter();
    TextExtractionStrategy strategy = new FilteredTextRenderListener(
            new LocationTextExtractionStrategy(), regionFilter, fontFilter);
    System.out.println(PdfTextExtractor.getTextFromPage(reader, 1, strategy));
    reader.close();
}