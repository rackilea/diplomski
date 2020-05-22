JAXBContext jc = JAXBContext.newInstance(Customer.class);

    Binder<Node> binder = jc.createBinder();
    Customer customer = (Customer) binder.unmarshal(document);
    customer.getAddress().setStreet("2 NEW STREET");
    binder.updateXML(customer);