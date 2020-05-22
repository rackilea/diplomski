public static void main(String[] args) throws IOException
{
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);

    // just a rectangle to be able to locate the checkbox
    PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, false);
    contentStream.addRect(100, 100, 50, 50);
    contentStream.setLineWidth(1);
    contentStream.setNonStrokingColor(Color.WHITE);
    contentStream.setStrokingColor(Color.BLACK);
    contentStream.stroke();
    contentStream.close();

    PDAcroForm acroForm = new PDAcroForm(document);
    PDCheckBox checkBox = new PDCheckBox(acroForm);
    checkBox.setPartialName("xxx");


    //PDAnnotationWidget widget = new PDAnnotationWidget();
    PDAnnotationWidget widget = checkBox.getWidgets().get(0);
    widget.setRectangle(new PDRectangle(100, 100, 10, 10));
    widget.setAnnotationFlags(4);
    widget.setPage(page);
    //widget.setParent(checkBox);

    // inspired by annot 92 of file from PDFBOX-563
    // annot 172 has "checkmark" instead, but more more complex, needs ZaDb

    String offNString = "1 g\n"
            + "0 0 9.5 9.5 re\n"
            + "f\n"
            + "0.5 0.5 9.5 9.5 re\n"
            + "s";
    String offDString = "0.75 g\n"
            + "0 0 9.5 9.5 re\n"
            + "f\n"
            + "0.5 0.5 9.5 9.5 re\n"
            + "s";
    String yesNString = "1 g\n"
            + "0 0 9 9.5 re\n"
            + "f\n"
            + "0.5 0.5 9.5 9.5 re\n"
            + "s\n"
            + "q\n"
            + "  1 1 9 9 re\n"
            + "  W\n"
            + "  n\n"
            + "  2 8 m\n"
            + "  8 2 l\n"
            + "  8 8 m\n"
            + "  2 2 l\n"
            + "  s\n"
            + "Q";
    String yesDString = "0.75 g\n"
            + "0 0 9 9.5 re\n"
            + "f\n"
            + "0.5 0.5 9.5 9.5 re\n"
            + "s\n"
            + "q\n"
            + "  1 1 9 9 re\n"
            + "  W\n"
            + "  n\n"
            + "  2 8 m\n"
            + "  8 2 l\n"
            + "  8 8 m\n"
            + "  2 2 l\n"
            + "  s\n"
            + "Q";

    COSDictionary apNDict = new COSDictionary();
    COSStream offNStream = new COSStream();
    offNStream.setItem(COSName.BBOX, new PDRectangle(10, 10));
    offNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    offNStream.setItem(COSName.TYPE, COSName.XOBJECT);
    offNStream.setItem(COSName.SUBTYPE, COSName.FORM);
    offNStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
    offNStream.setItem(COSName.RESOURCES, new COSDictionary());
    OutputStream os = offNStream.createOutputStream();
    os.write(offNString.getBytes());
    os.close();
    apNDict.setItem(COSName.Off, offNStream);

    COSStream yesNStream = new COSStream();
    yesNStream.setItem(COSName.BBOX, new PDRectangle(10, 10));
    yesNStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    yesNStream.setItem(COSName.TYPE, COSName.XOBJECT);
    yesNStream.setItem(COSName.SUBTYPE, COSName.FORM);
    yesNStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
    yesNStream.setItem(COSName.RESOURCES, new COSDictionary());
    os = yesNStream.createOutputStream();
    os.write(yesNString.getBytes());
    os.close();
    apNDict.setItem(COSName.getPDFName("Yes"), yesNStream);

    COSDictionary apDDict = new COSDictionary();
    COSStream offDStream = new COSStream();
    offDStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    offDStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    offDStream.setItem(COSName.TYPE, COSName.XOBJECT);
    offDStream.setItem(COSName.SUBTYPE, COSName.FORM);
    offDStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
    offDStream.setItem(COSName.RESOURCES, new COSDictionary());
    os = offDStream.createOutputStream();
    os.write(offDString.getBytes());
    os.close();
    apDDict.setItem(COSName.Off, offDStream);

    COSStream yesDStream = new COSStream();
    yesDStream.setItem(COSName.BBOX, new PDRectangle(16, 16));
    yesDStream.setItem(COSName.FORMTYPE, COSInteger.ONE);
    yesDStream.setItem(COSName.TYPE, COSName.XOBJECT);
    yesDStream.setItem(COSName.SUBTYPE, COSName.FORM);
    yesDStream.setItem(COSName.MATRIX, new Matrix().toCOSArray());
    yesDStream.setItem(COSName.RESOURCES, new COSDictionary());
    os = yesDStream.createOutputStream();
    os.write(yesDString.getBytes());
    os.close();
    apDDict.setItem(COSName.getPDFName("Yes"), yesDStream);

    PDAppearanceDictionary appearance = new PDAppearanceDictionary();
    PDAppearanceEntry appearanceNEntry = new PDAppearanceEntry(apNDict);
    appearance.setNormalAppearance(appearanceNEntry);

    // push appearance doesn't look nice enough, has weird effect when pushing
//        PDAppearanceEntry appearanceDEntry = new PDAppearanceEntry(apDDict);
//        appearance.setDownAppearance(appearanceDEntry);

    widget.setAppearance(appearance);

    // MK (appearance characteristics dictionary)
    COSDictionary acdDict = new COSDictionary();
    acdDict.setItem(COSName.CA, new COSString("8")); // 8 is X, 4 is checkmark
    COSArray bcArray = new COSArray();
    bcArray.add(COSInteger.ZERO);
    acdDict.setItem(COSName.BC, bcArray);
    COSArray bgArray = new COSArray();
    bgArray.add(COSInteger.ONE);
    acdDict.setItem(COSName.BG, bgArray);
    PDAppearanceCharacteristicsDictionary acd = new PDAppearanceCharacteristicsDictionary(acdDict);
    widget.setAppearanceCharacteristics(acd);

//        List<PDAnnotationWidget> widgets = new ArrayList<>();
//        widgets.add(widget);
    page.getAnnotations().add(widget);
//        checkBox.setWidgets(widgets);

    checkBox.setValue("Yes");

    acroForm.getFields().add(checkBox);
    document.getDocumentCatalog().setAcroForm(acroForm);

    File file = new File("checkbox.pdf");

    document.save(file);
    document.close();
}