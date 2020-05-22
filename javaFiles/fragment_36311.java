public static PdfAction gotoRemotePage(String filename, String dest, boolean isName, boolean newWindow) {
    PdfAction action = new PdfAction();
    action.put(PdfName.F, new PdfString(filename));
    action.put(PdfName.S, PdfName.GOTOR);
    if (isName)
        action.put(PdfName.D, new PdfName(dest));
    else
        action.put(PdfName.D, new PdfString(dest, PdfObject.TEXT_UNICODE));
    if (newWindow)
        action.put(PdfName.NEWWINDOW, PdfBoolean.PDFTRUE);
    return action;
}