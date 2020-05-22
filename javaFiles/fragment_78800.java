@XmlRootElement
  public static class Element
  {
    @XmlElement
    String             name;

    @XmlAnyAttribute
    Map<QName, Object> map;
  }

  {
    //
    Element element = new Element();
    element.name = "a wonderful name";
    element.map = new HashMap<QName, Object>();
    element.map.put( new QName( "id" ), "1" );
    element.map.put( new QName( "other" ), "2" );
  }