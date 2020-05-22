public static void addPage(PDDocument doc, int index, PDPage page)
{
    PDPageNode rootPages = doc.getDocumentCatalog().getPages();
    rootPages.getKids().add(index, page);
    page.setParent(rootPages);
    rootPages.updateCount();
}