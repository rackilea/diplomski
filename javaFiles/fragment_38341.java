class PersonConverter implements Converter {

    public boolean canConvert(Class clazz) {
        return clazz.equals(Person.class);
    }

    public void marshal(Object value, 
                        HierarchicalStreamWriter writer, 
                        MarshallingContext context) {
        Person person = (Person) value;
        writer.addAttribute("version", "0");
        writer.startNode("fullname");
        writer.setValue(person.getName());
        writer.endNode();
    }

    public Object unmarshal(HierarchicalStreamReader reader, 
                            UnmarshallingContext context) {
        Person person = new Person();
        reader.moveDown();
        person.setName(reader.getValue());
        reader.moveUp();
        return person;
    }
}