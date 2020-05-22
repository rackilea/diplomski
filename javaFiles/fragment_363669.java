@Test
public void testUnmarshall() throws Exception {
    JAXBContext context = JAXBContext.newInstance(DesignTheory.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    File file = new File("design-theory.xml");
    DesignTheory designTheory = (DesignTheory) unmarshaller.unmarshal(file);
    Assert.assertNotNull(designTheory.getDlrnotes());
    Assert.assertEquals(4, designTheory.getDlrnotes().size());
}