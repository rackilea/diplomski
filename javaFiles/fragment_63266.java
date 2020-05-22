@Test
public void testControllers() {
    final String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><controllers><controller><storageInfo><name>My name</name></storageInfo></controller></controllers>";
    final XStream stream = new XStream();
    stream.processAnnotations(ControllerList.class);
    final ControllerList controllers = (ControllerList) stream.fromXML(xml);

    final List<Controller> colls = controllers.getControllers();
    Assert.assertEquals(colls.size(), 1);

    final Controller coll = colls.get(0);

    final List<BasicInfo> infos = coll.getStorage();

    Assert.assertEquals(infos.size(), 1);

    final BasicInfo info = infos.get(0);

    Assert.assertEquals(info.getName(), "My name");
}