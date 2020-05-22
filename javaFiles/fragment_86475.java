@XmlRootElement(name="Root")
class Root {
    private MyElement myElement;

    @XmlElement(name="Test")
    public MyElement getMyElement() { return myElement; }
    public void setMyElement(MyElement myElement) { this.myElement = myElement; }
}