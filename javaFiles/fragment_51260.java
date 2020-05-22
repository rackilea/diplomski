final COSName POPUP = COSName.getPDFName("Popup");

PDDocument document = PDDocument.load(resource);
List<PDAnnotation> annotations = new ArrayList<>();
PDPageTree allPages = document.getDocumentCatalog().getPages();

List<COSObjectable> objectsToRemove = new ArrayList<>();

for (int i = 0; i < allPages.getCount(); i++) {
    PDPage page = allPages.get(i);
    annotations = page.getAnnotations();

    for (PDAnnotation annotation : annotations) {
        if ("StrikeOut".equals(annotation.getSubtype()))
        {
            COSDictionary annotationDict = annotation.getCOSObject();
            COSBase popup = annotationDict.getItem(POPUP);
            annotationDict.removeItem(POPUP);            // popup annotation
            annotationDict.removeItem(COSName.CONTENTS); // plain text comment
            annotationDict.removeItem(COSName.RC);       // rich text comment
            annotationDict.removeItem(COSName.T);        // author

            if (popup != null)
                objectsToRemove.add(popup);
        }
    }

    annotations.removeAll(objectsToRemove);
}