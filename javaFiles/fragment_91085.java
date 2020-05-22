PdfFileSpecification fs = PdfFileSpecification.fileEmbedded(
    stamper.getWriter(), // correct
    null, // should be "C:\\Users\\User\\Desktop\\testEmbed.pdf"
    "tests.pdf", // correct
    PDFContent2, // this is completely wrong!!!
    "pdf", // should be "application/pdf"
    null, // OK
    0); // choosing 0 means that you don't want to compress the attachment. Why not?