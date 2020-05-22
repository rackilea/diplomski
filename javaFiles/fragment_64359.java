class Resolver implements EntityResolver {

  public InputSource resolveEntity(String publicId, String systemId) {
  if (systemId.equals("THE_SYSTEM_ID_THAT_YOU_ARE_USING")) {
     System.out.println("Resolving Entity...");
     return new InputSource("YOUR_REFERENCES_XML");
  } else {
     // use the default behaviour
     return null;
  }
  }
}