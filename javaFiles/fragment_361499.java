Class heroClass = 
for(Method method : heroClass.getMethods()) {
   Variable var = method.getAnnotation(Variable.class);
   if (var == null) continue; // ignore Object.getClass()
   String description = var.value; // text to display to users
   String attributeName = method.getName().substring(3); // cut "get"
   String initials = attributeName.replaceAll("[a-z]+", "");

}