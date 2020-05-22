StringWriter writer = new StringWriter();

JAXBContext jaxbContext = JAXBContext.newInstance(newBean.class);

newBean bean = new newBean();

bean.setUsername("user");
bean.setPassword("secret");

Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.marshal(bean, writer);

String result = writer.toString();

// print result to console
System.out.println(result);