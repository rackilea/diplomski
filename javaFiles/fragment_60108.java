public static void parse() throws JAXBException, IOException {
    try (FileInputStream adrFile = new FileInputStream("test")) {
        JAXBContext ctx = JAXBContext.newInstance(RootElementClass.class);
        Unmarshaller um = ctx.createUnmarshaller();
        RootElementClass rootElement = (RootElementClass) um.unmarshal(adrFile);
    }
}