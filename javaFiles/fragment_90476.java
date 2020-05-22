public Document serialise() throws Exception {
    MyClass myObjectToMarshall = this.getObjectToMarshall();
    JAXBContext jc = JAXBContext.newInstance(MyClass.class);
    DOMResult domResult = new DOMResult();
    jc.createMarshaller().marshal(myObjectToMarshall, domResult);
    return (Document)domResult.getNode();
}