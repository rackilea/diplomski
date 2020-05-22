public void createPdf(String dest) throws IOException, FileNotFoundException{
    PdfWriter writer = new PdfWriter(dest);
    PdfDocument pdfDoc = new PdfDocument(writer);
    Document doc = new Document(pdfDoc);
    pdfDoc.setDefaultPageSize(PageSize.A5);//All pages will be added using this page size
    String paragraphOneText = "I have seen the face of sorrow\n" +
            "She looks away in the distance\n" +
            "Across all these bridges\n" +
            "From whence I came\n" +
            "And those spans, trussed and arched\n" +
            "Hold up our lives as we go back again\n" +
            "To how we thought then\n" +
            "To how we thought we thought then";
    String paragraphTwoText = "I have seen sorrow's face,\n" +
            "But she is ever turned away\n" +
            "And her words leave me blind\n" +
            "Her eyes make me mute\n" +
            "I do not understand what she says to me\n" +
            "I do not know if to obey\n" +
            "Or attempt a flood of tears";
    String paragraphThreeText  = "I have seen her face\n" +
            "She does not speak\n" +
            "She does not weep\n" +
            "She does not know me\n" +
            "For I am but a stone fitted in place\n" +
            "On the bridge where she walks";
    String attribution = "--Toc the Younger";

    Paragraph p = new Paragraph(paragraphOneText);
    //Current default pagesize is A5, so any new pages will be created as A5
    doc.add(p);
    //Changing default pagesize will affect any new pages that are created
    pdfDoc.setDefaultPageSize(PageSize.A5.rotate());
    //Adding an areabreak of type NEXT_PAGE will force the creation of a new page
    doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    p = new Paragraph(paragraphTwoText);
    doc.add(p);
    pdfDoc.setDefaultPageSize(PageSize.A5);
    doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    p = new Paragraph(paragraphThreeText);
    doc.add(p);
    p= new Paragraph(attribution);
    doc.add(p);
    doc.close();
}