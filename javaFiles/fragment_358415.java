for (Field field : Person.class.getDeclaredFields()) {
    System.out.print("Field: " + field.getName() + " - ");
    Type type = field.getGenericType();
    if (type instanceof ParameterizedType) {
        ParameterizedType pType = (ParameterizedType)type;
        System.out.print("Raw type: " + pType.getRawType() + " - ");
        System.out.println("Type args: " + pType.getActualTypeArguments()[0]);
    } else {
        System.out.println("Type: " + field.getType());
    }
}