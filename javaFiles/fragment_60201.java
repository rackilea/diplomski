PDDocument document = ...;
PDDocument singlePageDocument = ...;
PDPage singlePage = (PDPage) singlePageDocument.getDocumentCatalog().getAllPages().get(0);

PDPageNode rootPages = document.getDocumentCatalog().getPages();
rootPages.getKids().add(3-1, singlePage);
singlePage.setParent(rootPages);
singlePage = new PDPage(new COSDictionary(singlePage.getCOSDictionary()));
rootPages.getKids().add(7-1, singlePage);
singlePage = new PDPage(new COSDictionary(singlePage.getCOSDictionary()));
rootPages.getKids().add(10-1, singlePage);
rootPages.updateCount();

document.save(...);