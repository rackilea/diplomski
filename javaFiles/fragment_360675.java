CarImpl myModel = new CarImpl();

File xmlFile = new File("model.xml");

XStream xstream = new XStream();
xstream.useAttributeFor(String.class);
xstream.useAttributeFor(Integer.class);

Writer writer = new FileWriter(xmlFile);        
writer.write(xstream.toXML(myModel));
writer.close();

CarImpl fromXML = (CarImpl) xstream.fromXML(new FileInputStream(xmlFile));
System.out.println(fromXML);