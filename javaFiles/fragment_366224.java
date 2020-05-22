PdfReader reader = new PdfReader(src);
int n = reader.getNumberOfPages();
PdfDictionary page;
for (int p = 1; p <= n; p++) {
    page = reader.getPageN(p);
    page.put(PdfName.USERUNIT, new PdfNumber(1f));
}
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
stamper.close();
reader.close();