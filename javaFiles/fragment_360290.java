@Test
public void test1() {
    DatacenterMachineMapping dcm = new DatacenterMachineMapping(
            Arrays.asList("phx", "slc", "vs"),
            Arrays.asList("h0", "h1", "h2", "h3"));

    Map<String, String> m1 = dcm.getDatacenterMachineMapping();
    Assert.assertEquals("h0", m1.get("phx"));
    Assert.assertEquals("h1", m1.get("slc"));
    Assert.assertEquals("h2", m1.get("vs"));

    Map<String, String> m2 = dcm.getDatacenterMachineMapping();
    Assert.assertEquals("h1", m2.get("phx"));
    Assert.assertEquals("h2", m2.get("slc"));
    Assert.assertEquals("h3", m2.get("vs"));

    Map<String, String> m3 = dcm.getDatacenterMachineMapping();
    Assert.assertEquals("h2", m3.get("phx"));
    Assert.assertEquals("h3", m3.get("slc"));
    Assert.assertEquals("h0", m3.get("vs"));

    Map<String, String> m4 = dcm.getDatacenterMachineMapping();
    Assert.assertEquals("h3", m4.get("phx"));
    Assert.assertEquals("h0", m4.get("slc"));
    Assert.assertEquals("h1", m4.get("vs"));

    Map<String, String> m5 = dcm.getDatacenterMachineMapping();
    Assert.assertNull(m5.get("phx"));
    Assert.assertNull(m5.get("slc"));
    Assert.assertNull(m5.get("vs"));
}