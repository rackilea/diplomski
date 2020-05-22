public class PersonSerializer implements JsonbSerializer<Person> {
    @Override
    public void serialize(Person person, JsonGenerator generator, SerializationContext serializationContext) {
        generator.writeStartObject();
        generator.write("id", person.getId());
        if (person.getName() != null && !person.getName().isEmpty()) {
            generator.write("name", person.getName());
        }
        if (person.getEmail() != null && !person.getEmail().isEmpty()) {
            generator.write("email", person.getEmail());
        }
        // ...
        generator.writeEnd();
    }
}