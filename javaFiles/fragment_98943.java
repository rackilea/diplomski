public static void main(String[] args) throws Exception {
    StringWriter writer = new StringWriter();
    Project project = new Project("1", "POP");
    JAXBContext contect = JAXBContext.newInstance(project.getClass());
    Marshaller marshaller = contect.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    marshaller.marshal(project, writer);
    System.out.println( writer.toString());

}