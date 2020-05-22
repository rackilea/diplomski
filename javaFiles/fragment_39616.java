try {
   String className = "com.path.to.ImplementationType";// really passed in from config
   Class c = Class.forName(className);
   InterfaceType interfaceType = (InterfaceType)c.newInstance();
   if (className.equals("com.path.to.ImplementationType") {
      ((ImplementationType)interfaceType).doSomethingOnlyICanDo();
   } 
} catch (Exception e) {
   e.printStackTrace();
}