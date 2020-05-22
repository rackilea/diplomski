@Path("/download-relatorio")
public Download download() {
    // Everything will be stored into this OutputStream
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    InputStream input = new ByteArrayInputStream(build.toString().getBytes());
    Tidy tidy = new Tidy();
    Document doc = tidy.parseDOM(input, null);
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocument(doc, null);
    renderer.layout();
    renderer.createPDF(out);
    out.flush();
    out.close();

    // Now that you have finished, return a new ByteArrayDownload()
    // The 2nd and 3rd parameters are the Content-Type and File Name
    // (which will be shown to the end-user)
    return new ByteArrayDownload(out.toByteArray(), "application/pdf", "Relatorio.pdf");
}