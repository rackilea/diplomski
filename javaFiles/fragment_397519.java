String name;
String value;
Method[] methods = Child.class.getMethods();
for (Method method : methods) {
    if (!method.getName().equals(name))
        continue;
    Class<?> paramType = method.getParameterTypes()[0];
    //You will have to figure how to convert the String value to the parameter.
    method.invoke(child, paramType.cast(value)); // for example
}