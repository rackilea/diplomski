Document document = new Document(PageSize.A1.rotate());
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(directory_path+filename));
document.open();
PdfPTable table = new PdfPTable(15);
table.setWidthPercentage(100);

... create cells and add them to the table ...

document.add(table);
document.close();