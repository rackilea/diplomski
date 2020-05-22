// you probably don't need this first line
// but you'd need it if you were manipulating an existing document
IBody body = doc.getBodyElements().get(0).getBody();
for (XWPFParagraph par : body.getParagraphs()) {
    // work the crazy abbreviated API magic
    CTSpacing spacing = par.getCTP().getPPr().getSpacing();
    if (spacing == null) {
        // it looks hellish to create a CTSpacing object yourself
        // so let POI do it by setting any Spacing parameter
        par.setSpacingLineRule(LineSpacingRule.AUTO);
        // now the Paragraph's spacing shouldn't be null anymore
        spacing = par.getCTP().getPPr().getSpacing();
    }
    // you can set your value, as demonstrated by the XML
    spacing.setAfter(BigInteger.valueOf(480));
    // not sure if this one is necessary
    spacing.setLineRule(STLineSpacingRule.Enum.forString("auto"));
}