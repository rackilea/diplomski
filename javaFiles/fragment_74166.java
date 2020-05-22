public class FooSerialization {

    public static class Foo {
        private String title;
        private String message;
    }

    public static class Foo2 {
        private String value;
        private String variable;
    }

    public static class ClassDTO {

        private String type;
        private List<FieldDTO> fields;

    }

    public static class FieldDTO {
        private String type;
        private String value;
        private String fieldName;
    }

    public static void main(String[] args) throws JsonProcessingException {

        Foo2 foo2 = new Foo2();
        foo2.setValue("valueMessage");
        foo2.setVariable("variableMessage");
        Foo foo = new Foo();
        foo.setMessage("messageMessage");
        foo.setTitle("titleMessage");

        ObjectMapper mapper = new ObjectMapper();

        List<ClassDTO> dtos = new ArrayList<ClassDTO>();
        dtos.add(convert(foo));
        dtos.add(convert(foo));
        System.out.println(mapper.writeValueAsString(dtos));
    }

    private static ClassDTO convert(Object obj) {
        ClassDTO dto = new ClassDTO();
        dto.setType(obj.getClass().getSimpleName());
        List<FieldDTO> fieldDTOs = new ArrayList<FieldDTO>();
        dto.setFields(fieldDTOs);

        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            FieldDTO fieldDto = new FieldDTO();
            try {
                fieldDto.setFieldName(field.getName());
                fieldDto.setValue(field.get(obj).toString());
                fieldDto.setType(field.getType().getSimpleName());
                fieldDTOs.add(fieldDto);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dto;
    }

}