public static void basicReflection(Object obj) throws IllegalAccessException {
    Class<?> objClass = obj.getClass();
    System.out.println("obj: " + obj.getClass());

    Field[] fields = objClass.getDeclaredFields();
    for(Field field : fields) {
        field.setAccessible(true);
        System.out.println("Field: " + field.getName() + " value: " + field.get(obj));
        if (field.getType() == Bar.class) {
            System.out.println("Field is a Bar");
        }
    }
}