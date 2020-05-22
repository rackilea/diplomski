FileInputStream xsd = new FileInputStream("src/example/customer.xsd");
DynamicJAXBContext jaxbContext = 
    DynamicJAXBContextFactory.createContextFromXSD(xsd, null, null, null);

FileInputStream xmlInputStream = new FileInputStream("src/example/dynamic/customer.xml");
Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
DynamicEntity customer = (DynamicEntity) unmarshaller.unmarshal(xmlInputStream);

System.out.println(customer.<String>get("name"));