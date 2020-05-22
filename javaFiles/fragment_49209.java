public static void main(String[] args) throws Exception {

    Map<String, String> map = new HashMap<>();

    Field[] fields = Contact.class.getDeclaredFields();

    for (Field field : fields) {
        if (field.isAnnotationPresent(JsonProperty.class)) {
            String annotationValue = field.getAnnotation(JsonProperty.class).value();
            map.put(annotationValue, field.getName());
        }
    }
}