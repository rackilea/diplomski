class MyElement {
    private String test;

    @XmlElement(name="Test")
    public String getTest() { return test; }
    public void setTest(String test) { this.test = test; }  
}