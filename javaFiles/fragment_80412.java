File originalPdf = new File("{File Location}");
    PDDocument srcDoc = PDDocument.load(originalPdf);
    PDDocument dstDoc = new PDDocument();

    List<PDPage> srcPages = srcDoc.getDocumentCatalog().getAllPages();

    for (int p = 0; p < srcPages.size(); ++p)
    {
        if (p >= 1 && p <= 4)
            dstDoc.addPage(srcPages.get(p));
    }

    dstDoc.save(file2);
    dstDoc.close();
    srcDoc.close();