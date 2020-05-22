Class1 obj = new Class1();

Class c = obj.getClass();
for (Method method : c.getDeclaredMethods()) {
    if (method.getAnnotation(JsonIgnore.class) == null &&
        method.getName().substring(0,3).equals("get")) {
        System.out.println(method.getName());
    }
}