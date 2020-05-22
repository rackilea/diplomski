public class DatacenterMachineMappingTest {

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
    }

    @Test
    public void test2() {
        DatacenterMachineMapping dcm = new DatacenterMachineMapping(
                Arrays.asList("phx", "slc", "vs"),
                Arrays.asList("h0", "h1", "h2"));

        Map<String, String> m1 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h0", m1.get("phx"));
        Assert.assertEquals("h1", m1.get("slc"));
        Assert.assertEquals("h2", m1.get("vs"));

        Map<String, String> m2 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h1", m2.get("phx"));
        Assert.assertEquals("h2", m2.get("slc"));
        Assert.assertEquals("h0", m2.get("vs"));

        Map<String, String> m3 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h2", m3.get("phx"));
        Assert.assertEquals("h0", m3.get("slc"));
        Assert.assertEquals("h1", m3.get("vs"));
    }

    @Test
    public void test3() {
        DatacenterMachineMapping dcm = new DatacenterMachineMapping(
                Arrays.asList("phx", "slc", "vs"),
                Arrays.asList("h0", "h1"));

        Map<String, String> m1 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h0", m1.get("phx"));
        Assert.assertEquals("h1", m1.get("slc"));
        Assert.assertEquals("h0", m1.get("vs"));

        Map<String, String> m2 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h1", m2.get("phx"));
        Assert.assertEquals("h0", m2.get("slc"));
        Assert.assertEquals("h1", m2.get("vs"));

        Map<String, String> m3 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h0", m3.get("phx"));
        Assert.assertEquals("h1", m3.get("slc"));
        Assert.assertEquals("h0", m3.get("vs"));
    }

    @Test
    public void test4() {
        DatacenterMachineMapping dcm = new DatacenterMachineMapping(
                Arrays.asList("phx", "slc", "vs"),
                Arrays.asList("h0", "h1", "h2", "h3", "h4", "h5", "h6"));

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
        Assert.assertEquals("h4", m3.get("vs"));

        Map<String, String> m4 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h3", m4.get("phx"));
        Assert.assertEquals("h4", m4.get("slc"));
        Assert.assertEquals("h5", m4.get("vs"));

        Map<String, String> m5 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h4", m5.get("phx"));
        Assert.assertEquals("h5", m5.get("slc"));
        Assert.assertEquals("h6", m5.get("vs"));

        Map<String, String> m6 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h5", m6.get("phx"));
        Assert.assertEquals("h6", m6.get("slc"));
        Assert.assertEquals("h0", m6.get("vs"));

        Map<String, String> m7 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h6", m7.get("phx"));
        Assert.assertEquals("h0", m7.get("slc"));
        Assert.assertEquals("h1", m7.get("vs"));
    }

    @Test
    public void test5() {
        DatacenterMachineMapping dcm = new DatacenterMachineMapping(
                Arrays.asList("phx", "slc", "vs", "sls"),
                Arrays.asList("h0", "h1", "h2", "h3", "h4", "h5", "h6"));

        Map<String, String> m1 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h0", m1.get("phx"));
        Assert.assertEquals("h1", m1.get("slc"));
        Assert.assertEquals("h2", m1.get("vs"));
        Assert.assertEquals("h3", m1.get("sls"));

        Map<String, String> m2 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h2", m2.get("phx"));
        Assert.assertEquals("h3", m2.get("slc"));
        Assert.assertEquals("h4", m2.get("vs"));
        Assert.assertEquals("h5", m2.get("sls"));

        Map<String, String> m3 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h4", m3.get("phx"));
        Assert.assertEquals("h5", m3.get("slc"));
        Assert.assertEquals("h6", m3.get("vs"));
        Assert.assertEquals("h0", m3.get("sls"));

        Map<String, String> m4 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h6", m4.get("phx"));
        Assert.assertEquals("h0", m4.get("slc"));
        Assert.assertEquals("h1", m4.get("vs"));
        Assert.assertEquals("h2", m4.get("sls"));

        Map<String, String> m5 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h1", m5.get("phx"));
        Assert.assertEquals("h2", m5.get("slc"));
        Assert.assertEquals("h3", m5.get("vs"));
        Assert.assertEquals("h4", m5.get("sls"));

        Map<String, String> m6 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h3", m6.get("phx"));
        Assert.assertEquals("h4", m6.get("slc"));
        Assert.assertEquals("h5", m6.get("vs"));
        Assert.assertEquals("h6", m6.get("sls"));

        Map<String, String> m7 = dcm.getDatacenterMachineMapping();
        Assert.assertEquals("h5", m7.get("phx"));
        Assert.assertEquals("h6", m7.get("slc"));
        Assert.assertEquals("h0", m7.get("vs"));
        Assert.assertEquals("h1", m7.get("sls"));
    }
}