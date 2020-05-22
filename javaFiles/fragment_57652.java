@RequestMapping(value = "/test/data")
    public TestFormData dostuff() {
        TestFormData data = new TestFormData();
        data.setName("myname");
        return data;
    }