void saveAnnotationImages(PdfDocument pdfDocument, String prefix) throws IOException {
    for (int pageNumber = 1; pageNumber <= pdfDocument.getNumberOfPages(); pageNumber++) {
        PdfPage page = pdfDocument.getPage(pageNumber);
        int index = 0;
        for (PdfAnnotation annotation : page.getAnnotations()) {
            PdfDictionary normal = annotation.getAppearanceObject(PdfName.N);
            if (normal instanceof PdfStream) {
                Map<byte[], String> images = extractAnnotationImages((PdfStream)normal);
                for (Map.Entry<byte[], String> entry : images.entrySet()) {
                    Files.write(new File(String.format("%s-%s-%s.%s", prefix, pageNumber, index++, entry.getValue())).toPath(), entry.getKey());
                }
            }
        }
    }
}