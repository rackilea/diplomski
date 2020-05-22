//this is OK
className = obj.getClassName();
Class<?> classHandle = Class.forName(className);

//got the class, create an instance - no-args constructor needed!
Object myObject = classHandle.newInstance();

//iterate through all the methods declared by the class  
for(Method method : classHandle.getMethods()) {
   //check method name
   if(method.getName().matches("set[A-Z].*") 
       //check if it awaits for exactly one parameter
       && method.getParameterTypes().length==1) {

       String attributeName = getAttributeName(method.getName());
       //getAttributeName would chop the "set", and lowercase the first char of the name of the method (left out for clarity)

       //To be extra nice, type checks could be inserted here...
       method.invoke(myObject, attributeMap.get(attributeName));            

   }
}