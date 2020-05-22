PdfDocument mergedDoc = new PdfDocument(new PdfWriter(destination));
    PdfMerger merger = new PdfMerger(mergedDoc);
    for(File source : sources){
        // set source pdf
        PdfDocument sourcePdf = new PdfDocument(new PdfReader(source));
        // merge
        merger.merge(sourcePdf, 1, sourcePdf.getNumberOfPages()).setCloseSourceDocuments(true);
        // close source
        sourcePdf.close();
    }
    merger.close();
    mergedDoc.close();