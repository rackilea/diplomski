JAXBContext jc = JAXBContext.newInstance(Root.class);
Unmarshaller ums = jc.createUnmarshaller();
Root root = (Root)ums.unmarshal(new File("pathToYourFile"));
for (Root.Row r: root.getRow()){
  System.out.println("millis=" + r.getMillis());
  //ecc...
}