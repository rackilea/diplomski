public static void cloneParagraph(XWPFParagraph clone, XWPFParagraph source) {
    CTPPr pPr = clone.getCTP().isSetPPr() ? clone.getCTP().getPPr() : clone.getCTP().addNewPPr();
    pPr.set(source.getCTP().getPPr());
    for (XWPFRun r : source.getRuns()) {
        XWPFRun nr = clone.createRun();
        cloneRun(nr, r);
    }
}

public static void cloneRun(XWPFRun clone, XWPFRun source) {
    CTRPr rPr = clone.getCTR().isSetRPr() ? clone.getCTR().getRPr() : clone.getCTR().addNewRPr();
    rPr.set(source.getCTR().getRPr());
    clone.setText(source.getText(0));
}