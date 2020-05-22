Node originalDOM;  // Populate original document

JAXBContext jc = JAXBContext.newInstance(Customer.class);
Unmarshaller unmarshaller = jc.createUnmarshaller();
Customer customer = (Customer) unmarshaller.unmarshal(orginalDocument);

Marshaller marshaller = jc.createMarshaller();
marshalledDOM = marshaller.getNode(customer);