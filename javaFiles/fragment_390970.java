PDDocument doc = PDDocument.load(/*path to the file*/);
PDPage page = (PDPage)doc.getDocumentCatalog.getAllPages.get(i);
List annots = page.getAnnotations;
PDAnnotationTextMarkup markup = new PDAnnotationTextMarkup(PDAnnotationTextMarkup.Su....);
markup.setRectangle(/*your PDRectangle*/);
markup.setQuads(/*float array of size eight with all the vertices of the PDRectangle in anticlockwise order*/);
annots.add(markup);
doc.save(/*path to the output file*/);