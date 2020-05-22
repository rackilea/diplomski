JAXBContext jc = JAXBContext.newInstance(Node.class);
Marshaller m = jc.createMarshaller();

MainNode mainNode = new MainNode("node1 value", "node2 value");
MainNode2 mainNode2 = new MainNode2();
Node node = new Node(mainNode, mainNode2);

StringWriter sw = new StringWriter();

m.marshal(node, sw);

System.out.println(sw.toString());