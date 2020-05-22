public static void main(String[] args) throws PrintException, IOException {
    HelloWorldPrinter printer = new HelloWorldPrinter();
    printer.setPath("path/to/file");

    FileInputStream in = new FileInputStream(new File(printer.getPath()));
}