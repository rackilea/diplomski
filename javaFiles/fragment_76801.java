public static void generateBoo() {
    try {
        JAXBContext jc = JAXBContext.newInstance(XmlBoo.class);
        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.setProperty(MarshallerProperties.NAMESPACE_PREFIX_MAPPER, new MyNamespacePrefixMapper());

        XmlBoo xmlBoo = new XmlBoo();
        Header header = new Header();
        header.setId(101);
        xmlBoo.setHeader(header);

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Yen");
        Address address = new Address();
        address.setStreet("Long street");
        customer.setAddress(address);
        xmlBoo.setCustomer(customer);

        xmlBoo.setSomeBooSpecificField("Specific data in Boo");

        m.marshal(xmlBoo, System.out);
        m.marshal(xmlBoo, new File("xml_boo.xml"));

    } catch (JAXBException e) {
        e.printStackTrace();
    }
}