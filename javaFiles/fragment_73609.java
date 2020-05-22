Class<?> parentClass = getClass().getSuperclass();

Field[] fields = parentClass.getDeclaredFields();
for (Field field : fields) {
    System.out.println("field: " + field.getName());
}

Method[] methods = parentClass.getDeclaredMethods();
for (Method method : methods) {
    System.out.println("method: " + method.getName());
}