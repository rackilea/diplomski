PDFont font = PDType1Font.HELVETICA;
        PDResources res = new PDResources();
        String fontName = res.addFont(font);
        String defaultAppearance = "/"+fontName+" 7 Tf 0 g";

        COSDictionary acroFormDict = new COSDictionary(); 
        acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), false);
        acroFormDict.setItem(COSName.getPDFName("Fields"), new COSArray());
        acroFormDict.setItem(COSName.DA, new COSString(defaultAppearance));

        PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
        acroForm.setDefaultResources(res);