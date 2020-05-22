public void createPdf(String file) throws IOException, DocumentException {
    // step 1
    Document document = new Document();
    // step 2
    PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
    // step 3
    document.open();
    // step 4
    String str = "<html><head></head><body style=\"font-size:12.0pt; font-family:Times New Roman\">"+
            "<a href='http://www.rgagnon.com/howto.html'><b>Real's HowTo</b></a>" +
            "<h1>Show your support</h1>" +
            "<p>It DOES cost a lot to produce this site - in ISP storage and transfer fees</p>" +
            "<p>TEST POLSKICH ZNAKÓW: \u0104\u0105\u0106\u0107\u00d3\u00f3\u0141\u0142\u0179\u017a\u017b\u017c\u017d\u017e\u0118\u0119</p>" +
            "<hr/>" +
            "<p>the huge amounts of time it takes for one person to design and write the actual content.</p>" +
            "<p>If you feel that effort has been useful to you, perhaps you will consider giving something back?</p>" +
            "<p>Donate using PayPal\u017d</p>" +
            "<p>Contributions via PayPal are accepted in any amount</p>" +
            "<p><br/><table border='1'><tr><td>Java HowTo</td></tr><tr>" +
            "<td style='background-color:red;'>Javascript HowTo</td></tr>" +
            "<tr><td>Powerbuilder HowTo</td></tr></table></p>" +
            "</body></html>";

    XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
    InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
    worker.parseXHtml(writer, document, is, Charset.forName("UTF-8"));
    // step 5
    document.close();
}