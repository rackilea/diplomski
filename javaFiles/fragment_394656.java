in = new FileInputStream(inputPDF);
[...]
for (int pageNum = 0; pageNum < numPages; pageNum++) {
    reader = new PdfReader(in);
    [...]
}