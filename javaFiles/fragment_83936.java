class YourJaxbClass {
  @XmlElement(required = true)
  private String property1;

  @XmlElement //this one is not required
  private String property2;

  public YourJaxbClass copy(){
    YourJaxbClass copy = new YourJaxbClass();
    //only copy the required values:
    copy.property1 = this.property1;
    return copy;
  }
}