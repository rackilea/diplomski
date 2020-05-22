Rectangle pagesize = new Rectangle(width, max - y);
// step 1
Document document = new Document(pagesize, 0, 0, 0, 0);
// step 2
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
// step 3
document.open();
// step 4
ct = new ColumnText(writer.getDirectContent());
ct.setSimpleColumn(pagesize);
for (Element e : el) {
    ct.addElement(e);
}
ct.go();
// step 5
document.close();