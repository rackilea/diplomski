public class Main {
    String json = "{\"id\":1,\"fields\":[{\"type\":\"SIMPLE\",\"value\":\"Simple Value\"},{\"type\":\"NAME\",\"value\":{\"firstName\":\"first name\",\"lastName\":\"last name\"}}]}";

    public static void main(String []args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(generate());
        System.out.println(json);

        System.out.println(objectMapper.readValue(json, Contact.class));
    }

    private static Contact generate() {
        SimpleField simpleField = SimpleField.builder().type(FieldType.SIMPLE).value("Simple Value").build();

        NameFieldValue nameFieldValue = NameFieldValue.builder().firstName("first name").lastName("last name").build();
        NameField nameField = NameField.builder().type(FieldType.NAME).value(nameFieldValue).build();

        return Contact.builder().id(1).fields(Arrays.asList(simpleField, nameField)).build();
    }
}

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXTERNAL_PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleField.class, name = "SIMPLE"),
        @JsonSubTypes.Type(value = NameField.class, name = "NAME")
})
interface Field {
    FieldType getType();
    Object getValue();
}

enum FieldType {
    SIMPLE, NAME
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Contact {
    private int id;
    private List<Field> fields;
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class SimpleField implements Field {
    private FieldType type;
    private String value;

    @Override
    public FieldType getType() {
        return this.type;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class NameField implements Field {
    private FieldType type;
    private NameFieldValue value;

    @Override
    public FieldType getType() {
        return this.type;
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class NameFieldValue {
    private String firstName;
    private String lastName;
}