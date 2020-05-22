StringWriter writer = new StringWriter();

JAXBContext jaxbContext = JAXBContext.newInstance(newBean.class);

newBean bean = new newBean();

bean.setUsername("user");
bean.setPassword("secret");

JAXBElement<newBean> jaxbElement = new JAXBElement<Main.newBean>(new QName("name"), newBean.class, bean);

Marshaller marshaller = jaxbContext.createMarshaller();
marshaller.marshal(jaxbElement, writer);

String result = writer.toString();

// print result to console
System.out.println(result);