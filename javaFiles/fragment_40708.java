XMLInputFactory xif = XMLInputFactory.newInstance();
    StreamSource xml = new StreamSource(new StringReader(response.toString()));
    XMLStreamReader xsr = xif.createXMLStreamReader(xml);
    // Advance to the "Customer" elements
    while (xsr.hasNext()) {
        if (xsr.isStartElement() && "customer".equals(xsr.getLocalName())) {
            // Unmarshal to Customer
            JAXBContext jc = JAXBContext.newInstance(Customer.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Customer customer = unmarshaller.unmarshal(xsr, Customer.class).getValue();
            customers.add();
        }
        xsr.next();
     }