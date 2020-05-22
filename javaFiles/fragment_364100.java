String json = aceptaDefault();
JSONParser parser = new JSONParser();

ContainerFactory orderedKeyFactory = new ContainerFactory()
{
    public List creatArrayContainer() {
      return new LinkedList();
    }

    public Map createObjectContainer() {
      return new LinkedHashMap();
    }

};

Object obj = parser.parse(json,orderedKeyFactory);  
LinkedHashMap map = (LinkedHashMap)obj;