@XmlRootElement
@XmlSeeAlso(Hashtable.class)
public static class TypeWithHashtableAsObject {
    private Object property;

    public Object getProperty() {
        return property;
    }

    public void setProperty(Object property) {
        this.property = property;
    }

}

...
TypeWithHashtableAsObject foo = new TypeWithHashtableAsObject();
Hashtable<String, Integer> property = new Hashtable<>();
property.put("innerKey", 12);
foo.setProperty(property);
StringWriter writer = new StringWriter();
marshaller.marshal(foo, writer);
System.out.println(writer.toString());