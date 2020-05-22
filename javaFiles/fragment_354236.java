public class BPXProxy {

    private CloseableHttpClient client = HttpClients.createDefault();

    public InvoiceCreationInfo registerInvoice(InvoiceData invoice) throws SQLException, HttpException, IOException {
        JSONObject invoiceJSON = new JSONObject();
        invoiceJSON.put("invoicer", invoice.getInvoicerIdentification().getDocument());
        invoiceJSON.put("buyer", invoice.getBuyerIdentification().getDocument());
        String serviceURL = ConfigurationManager.getBPXServicesPath() + "Invoice?operation=registerExternalInvoice&branchCode="+ branchCode;
        HttpPost httpPost = new HttpPost(serviceURL);
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
        nvps.add("invoice", invoiceJSON.toJSONString());
        nvps.add("invoiceSubject", invoice.getInvoiceSubject());
        client.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse rsp = client.execute(httpPost);
        try {
            HttpEntity entity = rsp.getEntity();
            String rspJson = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return JSONSimpleHelper.parseJSON(rspJson);
        } finally {
            rsp.close();
        }
    }
}