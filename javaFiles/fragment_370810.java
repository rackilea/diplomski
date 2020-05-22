PDDocument pdd = null;
    try {
        pdd = PDDocument.load(inputStream);
        PDFParserTextStripper stripper = new PDFParserTextStripper(PDFdocument,pdd);
        stripper.setSortByPosition(true);
        for (int i=0;i<pdd.getNumberOfPages();i++){
            stripper.stripPage(i);
        }
    } catch (IOException e) {
        // throw error
    } finally {
        if (pdd!=null) {
            try {
                pdd.close();
            } catch (IOException e) {

            }
        }
    }