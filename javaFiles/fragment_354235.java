public class BPXProxy {
    private HttpClient client;
    public void init(){
        client = new HttpClient();
    }
    public InvoiceCreationInfo registerInvoice(InvoiceData invoice) throws SQLException, HttpException, IOException {
        JSONObject invoiceJSON = new JSONObject();
        invoiceJSON.put("invoicer", invoice.getInvoicerIdentification().getDocument());
        invoiceJSON.put("buyer", invoice.getBuyerIdentification().getDocument());
        String serviceURL = ConfigurationManager.getBPXServicesPath() + "Invoice?operation=registerExternalInvoice&branchCode="+ branchCode;
        PostMethod updatePage = new PostMethod(serviceURL);
        updatePage.addParameter("invoice", invoiceJSON.toJSONString());
        updatePage.addParameter("invoiceSubject", invoice.getInvoiceSubject());
        client.executeMethod(updatePage); // java.io.IOException: Stream closed, java.net.SocketException: Socket closed
        String response = updatePage.getResponseBodyAsString();  // java.io.IOException: chunked stream ended unexpectedly, java.io.IOException: CRLF expected at end of chunk: -1/-1
        updatePage.releaseConnection();
        JSONObject jsonResponse = JSONSimpleHelper.parseJSON(response);
        return jsonResponse;
    }
}