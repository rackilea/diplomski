// We create a list:
List list = new List();                
list.add(new ListItem("Item 1"));
list.add(new ListItem("Item 2"));
list.add(new ListItem("Item 3"));

// We wrap this list in a phrase:     
Phrase phrase = new Phrase();
phrase.add(list);
// We add this phrase to a cell
PdfPCell phraseCell = new PdfPCell();
phraseCell.addElement(phrase);           

// We add the cell to a table:
PdfPTable phraseTable = new PdfPTable(2);
phraseTable.setSpacingBefore(5);
phraseTable.addCell("List wrapped in a phrase:");
phraseTable.addCell(phraseCell);

// We wrap the phrase table in another table:
Phrase phraseTableWrapper = new Phrase();
phraseTableWrapper.add(phraseTable);

// We add these nested tables to the document:
document.add(new Paragraph("A list, wrapped in a phrase, wrapped in a cell, wrapped in a table, wrapped in a phrase:"));
document.add(phraseTableWrapper);

// This is how to do it:

// We add the list directly to a cell:
PdfPCell cell = new PdfPCell();
cell.addElement(list);
// We add the cell to the table:
PdfPTable table = new PdfPTable(2);
table.setSpacingBefore(5);
table.addCell("List placed directly into cell");
table.addCell(cell);