@SuppressWarnings("unchecked")
public void printFormFields(PDDocument pdfDoc) throws IOException {
    PDDocumentCatalog docCatalog = pdfDoc.getDocumentCatalog();

    List<PDPage> pages = docCatalog.getAllPages();
    Map<COSDictionary, Integer> pageNrByAnnotDict = new HashMap<COSDictionary, Integer>();
    for (int i = 0; i < pages.size(); i++) {
        PDPage page = pages.get(i);
        for (PDAnnotation annotation : page.getAnnotations())
            pageNrByAnnotDict.put(annotation.getDictionary(), i + 1);
    }

    PDAcroForm acroForm = docCatalog.getAcroForm();

    for (PDField field : (List<PDField>)acroForm.getFields()) {
        COSDictionary fieldDict = field.getDictionary();

        List<Integer> annotationPages = new ArrayList<Integer>();
        List<COSObjectable> kids = field.getKids();
        if (kids != null) {
            for (COSObjectable kid : kids) {
                COSBase kidObject = kid.getCOSObject();
                if (kidObject instanceof COSDictionary)
                    annotationPages.add(pageNrByAnnotDict.get(kidObject));
            }
        }

        Integer mergedPage = pageNrByAnnotDict.get(fieldDict);

        if (mergedPage == null)
            if (annotationPages.isEmpty())
                System.out.printf("i Field '%s' not referenced (invisible).\n", field.getFullyQualifiedName());
            else
                System.out.printf("a Field '%s' referenced by separate annotation on %s.\n", field.getFullyQualifiedName(), annotationPages);
        else
            if (annotationPages.isEmpty())
                System.out.printf("m Field '%s' referenced as merged on %s.\n", field.getFullyQualifiedName(), mergedPage);
            else
                System.out.printf("x Field '%s' referenced as merged on %s and by separate annotation on %s. (Not allowed!)\n", field.getFullyQualifiedName(), mergedPage, annotationPages);
    }
}