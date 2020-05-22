DocumentBuilder builder = new DocumentBuilder(doc);
// Insert PAGE field into the footer
builder.moveToHeaderFooter(HeaderFooterType.FOOTER_PRIMARY);
builder.startTable();
// Clear table borders
builder.getCellFormat().clearFormatting();
builder.insertCell();
// Set first cell to 1/3 of the page width.
builder.getCellFormat().setPreferredWidth(
PreferredWidth.fromPercent(100 / 3));
// Insert page numbering text here.
// It uses PAGE and NUMPAGES fields to auto calculate current page
// number and total number of pages.
builder.insertField("PAGE", null);
builder.write("/");
builder.insertField("NUMPAGES", null);
// Align this text to the left.
builder.getCurrentParagraph().getParagraphFormat()
.setAlignment(ParagraphAlignment.LEFT);
builder.insertCell();
// Set the second cell to 2/3 of the page width.
builder.getCellFormat().setPreferredWidth(
PreferredWidth.fromPercent(100 * 2 / 3));
builder.write("(C) 2017 Aspose Pty Ltd. All rights reserved.");
// Align this text to the right.
builder.getCurrentParagraph().getParagraphFormat()
.setAlignment(ParagraphAlignment.RIGHT);
builder.endRow();
builder.endTable();