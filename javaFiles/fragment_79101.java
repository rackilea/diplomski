int fieldCount = 35;
long start = System.nanoTime();

OutputStream file = new FileOutputStream(filename);
Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, file);
document.open();
for (int i = 0; i < fieldCount; ++i) {
    InputStream is = new ByteArrayInputStream(("<p>" + "Value " + i + "</p>").getBytes());
    XMLWorkerHelper.getInstance().parseXHtml(writer, document, is);
    document.add(new Paragraph("\n"));
}
document.close();

long end = System.nanoTime();
System.out.printf("Created %s with %d fields in %f seconds.\n", filename.getName(), fieldCount, ((float)end - (float)start) / 1000000000f);