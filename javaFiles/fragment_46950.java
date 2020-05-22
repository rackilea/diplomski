Method someMethod = Main.class.getDeclaredMethod("someMethod");
Parameter[] parameters = someMethod.getParameters();
for(Parameter parameter : parameters)
{
    System.out.println(parameter.getName());
}