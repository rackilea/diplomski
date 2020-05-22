int fieldCount = 10000;
long start = System.nanoTime();

OutputStream file = new FileOutputStream(filename);
Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, file);
document.open();
StringBuilder xmlString = new StringBuilder();
for (int i = 0; i < fieldCount; ++i) {
    xmlString.append("<p>")
             .append(("Value " + i))
             .append("</p>");
}
InputStream is = new ByteArrayInputStream(xmlString.toString().getBytes());
XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
document.close();

long end = System.nanoTime();
System.out.printf("Created %s with %d fields in %f seconds.\n", filename.getName(), fieldCount, ((float)end - (float)start) / 1000000000f);