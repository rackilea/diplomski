public static final String SRC = "resources/pdfs/primes.pdf";
public static final String[] EXTRA =
    {"resources/pdfs/hello.pdf", "resources/pdfs/base_url.pdf", "resources/pdfs/state.pdf"};
public static final String DEST = "results/stamper/primes_superimpose.pdf";

PdfReader reader = new PdfReader(SRC);
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(DEST));
PdfContentByte canvas = stamper.getUnderContent(1);
PdfReader r;
PdfImportedPage page;
for (String path : EXTRA) {
    r = new PdfReader(path);
    page = stamper.getImportedPage(r, 1);
    canvas.addTemplate(page, 0, 0);
    stamper.getWriter().freeReader(r);
    r.close();
}
stamper.close();