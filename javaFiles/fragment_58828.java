private static void addHyperlink(XWPFParagraph p_paragraphCell, XWPFParagraph p_paragraphLink, String p_linkedText, String p_paragraphText) {
    // Create hyperlink in paragraph
    CTHyperlink cLink = p_paragraphLink.getCTP().addNewHyperlink();
    cLink.setAnchor(p_paragraphText);
    // Create the linked text
    CTText ctText = CTText.Factory.newInstance();
    ctText.setStringValue(p_linkedText);
    CTR ctr = CTR.Factory.newInstance();
    ctr.setTArray(new CTText[] { ctText });

    // Insert the linked text into the link
    cLink.setRArray(new CTR[] { ctr });

    p_paragraphCell.getCTP().setHyperlinkArray(new CTHyperlink[] { cLink });
    p_paragraphLink.getCTP().removeHyperlink(0);
}