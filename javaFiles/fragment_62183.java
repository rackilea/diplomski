//Set AcroForm Appearance Characteristics
    PDResources resources = new PDResources();
    defaultFont = PDType0Font.load(pdf,
            new PDTrueTypeFont(PDType1Font.HELVETICA.getCOSObject()).getTrueTypeFont(), true);
    resources.put(COSName.getPDFName("Helv"), defaultFont);
    acroForm.setNeedAppearances(true);
    acroForm.setXFA(null);
    acroForm.setDefaultResources(resources);
    acroForm.setDefaultAppearance(DEFAULT_APPEARANCE);