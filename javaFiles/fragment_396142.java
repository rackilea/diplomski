RequestBuilder rb = new RequestBuilder(RequestBuilder.POST, "./REST/Items");
rb.setHeader("Content-Type", "application/xml");
rb.sendRequest("<?xml version='1.0' encoding='UTF-8'?>\n\n"+  
    "<item barcode='111'><name>Foo</name><quantity>100</quantity></item>",
    new RequestCallback() { ... }
);