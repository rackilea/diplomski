Object someObject = myObject();
for (Field field : someObject.getClass().getDeclaredFields()) {
    field.setAccessible(true); // You might want to set modifier to public first.
    Object value = field.get(someObject); 
    if (value != null) {
        System.out.println(field.getName() + "=" + value);
    }
}