try {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);

        document.addPage(page);

        PDAcroForm acroForm = new PDAcroForm(document);
        acroForm.setNeedAppearances(true);
        acroForm.setXFA(null);
        document.getDocumentCatalog().setAcroForm(acroForm);

        PDFont font = PDType1Font.HELVETICA;

        PDResources res = new PDResources();
        COSName fontName = res.add(font);
        acroForm.setDefaultResources(res);
        acroForm.setDefaultAppearance('/' + fontName.getName() + " 10 Tf 0 g");

        PDPageContentStream contents = new PDPageContentStream(document, page);

        List<String> options = Arrays.asList("a", "b", "c");
        PDRadioButton radioButton = new PDRadioButton(acroForm);
        radioButton.setPartialName("RadioButtonParent");
        radioButton.setExportValues(options);
        radioButton.getCOSObject().setName(COSName.DV, options.get(1));

        List<PDAnnotationWidget> widgets = new ArrayList<>();
        for (int i = 0; i < options.size(); i++) {

            PDAppearanceCharacteristicsDictionary fieldAppearance = new PDAppearanceCharacteristicsDictionary(new COSDictionary());
            fieldAppearance.setBorderColour(new PDColor(new float[]{0, 0, 0}, PDDeviceRGB.INSTANCE));

            PDAnnotationWidget widget = new PDAnnotationWidget();
            widget.setRectangle(new PDRectangle(30, 811 - i * (21), 16, 16));
            widget.setAppearanceCharacteristics(fieldAppearance);

            widgets.add(widget);
            page.getAnnotations().add(widget);

            // added by Tilman on 13.1.2017, without it Adobe does not set the values properly
            PDAppearanceDictionary appearance = new PDAppearanceDictionary();
            COSDictionary dict = new COSDictionary();
            dict.setItem(COSName.getPDFName("Off"), new COSDictionary());
            dict.setItem(COSName.getPDFName(options.get(i)), new COSDictionary());
            PDAppearanceEntry appearanceEntry = new PDAppearanceEntry(dict);
            appearance.setNormalAppearance(appearanceEntry);
            widget.setAppearance(appearance);


            contents.beginText();
            contents.setFont(font, 10);
            contents.newLineAtOffset(56, 811 - i * (21) + 4);
            contents.showText(options.get(i));
            contents.endText();
        }
        radioButton.setWidgets(widgets);
        acroForm.getFields().add(radioButton);

        contents.close();
        try(FileOutputStream output = new FileOutputStream("Test.pdf")) {
            document.save(output);
        }
        document.close();
    } catch (IOException e) {
        e.printStackTrace();
    }