public static void premain(String agentArgs, Instrumentation inst) {
  System.out.println(System.getProperty("java.version"));
  System.out.println(inst.isRedefineClassesSupported());
  int num=0;
  for(Class<?> clazz:inst.getAllLoadedClasses())
    if(!clazz.isArray() && !inst.isModifiableClass(clazz)) {
      System.out.println("not modifiable "+clazz);
      num++;
    }
  System.out.println((num==0? "all classes are": num+" classes are not")+" transformable");
}