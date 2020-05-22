for (Method m : ExampleClass.class.getDeclaredMethods()) {
    System.out.println(m.getName() + ": " + m.getGenericReturnType());
}

for (Field f : ExampleClass.class.getDeclaredFields()) {
    System.out.println(f.getName() + ": " + f.getType());
}