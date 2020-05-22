try (OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(txtFile), Charsets.UTF_8);
         PDDocument document = PDDocument.load(pdfFile))
    {
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.writeText(document, out);
    }