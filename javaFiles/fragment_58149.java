public String firstInvoiceNumber() throws IOException {
    Rectangle invoiceRectangle = new Rectangle(176, 176, 100, 18);
    String headerTextResult = "";
    for (PDPage pd : getPages()) {
        headerTextResult = StripByArea(pd, invoiceRectangle);
        if(!"".equals(headerTextResult)) {
            break;
        }
    }
    return headerTextResult;
}