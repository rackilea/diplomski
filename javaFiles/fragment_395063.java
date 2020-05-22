@Test
  public void testXML() {
    try {
      File file = new File("./src/main/resources/employee.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Departments.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Departments departments = (Departments) jaxbUnmarshaller.unmarshal(file);
      System.out.println(departments);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }