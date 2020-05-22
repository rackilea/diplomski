FontProvider fontProvider = new FontProvider("Arial");
fontProvider.addFont("C:/Windows/Fonts/arial.ttf");
fontProvider.addFont("C:/Windows/Fonts/arialbd.ttf");

Document document = new Document(pdfDocument);
document.setFontProvider(fontProvider);

for (int i = 0; i < 10; i++) {
    List<IElement> convertToElements = HtmlConverter.convertToElements(html);
    Paragraph p = (Paragraph) convertToElements.get(0);
    p.setProperty(Property.FONT_PROVIDER, fontProvider);
    document.add(p);
}