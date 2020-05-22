if (printer.getName().contains("ZM400")) {
    Arrays.stream(printer.getSupportedDocFlavors()).forEach(f->System.out.println(f.getMediaType() + ":" + f.getMimeType() + ":" + f.getRepresentationClassName()));
    String hello = "Hello";
    DocFlavor flavor = DocFlavor.STRING.TEXT_PLAIN;
    Doc doc = new SimpleDoc(hello, flavor, null);
    job = printer.createPrintJob();
    job.print(doc, null);
}