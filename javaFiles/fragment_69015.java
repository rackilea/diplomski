if (printer.getName().contains("ZM400")) {
    String hello = "Hello";
    DocFlavor flavor = DocFlavor.STRING.TEXT_PLAIN;
    Doc doc = new SimpleDoc(hello, flavor, null);
    job = printer.createPrintJob();
    job.print(doc, null);
}