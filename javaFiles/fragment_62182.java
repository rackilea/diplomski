//Setup new document
    pdf = new PDDocument();
    acroForm = new PDAcroForm(pdf);
    pdf.getDocumentInformation().setTitle(title);
    //Adjust other document metadata
    PDDocumentCatalog documentCatalog = pdf.getDocumentCatalog();
    documentCatalog.setLanguage("English");
    documentCatalog.setViewerPreferences(new PDViewerPreferences(new COSDictionary()));
    documentCatalog.getViewerPreferences().setDisplayDocTitle(true);
    documentCatalog.setAcroForm(acroForm);
    documentCatalog.setStructureTreeRoot(structureTreeRoot);
    PDMarkInfo markInfo = new PDMarkInfo();
    markInfo.setMarked(true);
    documentCatalog.setMarkInfo(markInfo);