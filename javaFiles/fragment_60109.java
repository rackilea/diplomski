public static void parse(RootElementClass out) throws IOException, JAXBException {
    try (FileOutputStream adrFile = new FileOutputStream("test.xml")) {
        JAXBContext ctx = JAXBContext.newInstance(RootElementClass.class);
        Marshaller ma = ctx.createMarshaller();
        ma.marshal(out, adrFile);
    }
}