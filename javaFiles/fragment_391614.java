public static void premain(String agentArgs, Instrumentation inst) {
  System.out.println(System.getProperty("java.version"));
  System.out.println(inst.isRedefineClassesSupported());
  int num=0;
  for(Class<?> clazz:inst.getAllLoadedClasses())
    if(clazz.getClassLoader()!=null) {
      System.out.println("already loaded "+clazz);
      num++;
    }
  System.out.println(num+" non-bootstrap class(es) loaded");
}