public static void readBoo() {

    Object element = null;

    try {
        JAXBContext jc = JAXBContext.newInstance(XmlBoo.class);
        Unmarshaller u = jc.createUnmarshaller();
        element = u.unmarshal(new File("xml_boo.xml"));

    } catch (JAXBException e) {
        e.printStackTrace();
    }

    if (element instanceof XmlBoo) {
        XmlBoo xmlBoo = (XmlBoo) element;
        Customer customer = xmlBoo.getCustomer();

        System.out.println("INFO | xmlBoo field:  [" + xmlBoo.getSomeBooSpecificField() + "]");
        System.out.println("INFO | customer name: [" + customer.getName() + "]");
        System.out.println("INFO | address street: [" + customer.getAddress().getStreet() + "]");

    }
}