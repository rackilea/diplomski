public static void main(String[] args) throws Exception {
    String files = "123456.XML";
    int index = files.toLowerCase().indexOf(".xml");
    String pdfName;
    if (index > -1) {
        pdfName = files.substring(0, index) + ".pdf";
    } else {
        pdfName = files + ".pdf";
    }
    System.out.println(pdfName);
}