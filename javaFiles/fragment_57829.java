XStream xStream = new XStream();
xStream.processAnnotations(ParentResponseObject.class);
ParentResponseObject parent = (ParentResponseObject)xStream.fromXML(file);
for (ResponseObject o : parent.getResponseObjects()) {
    System.out.println(o.getType() + ":" + o.getValue());
}