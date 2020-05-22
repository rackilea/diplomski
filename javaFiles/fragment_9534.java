Class<?> clazz = Class.forName(FULL_CLASS_NAME);
try {
    Field f = clazz.getField("sumUp");
    System.out.println("sumUp field exists");
} catch (NoSuchFieldException e){
    System.out.println("sumUp field does not exist");
}