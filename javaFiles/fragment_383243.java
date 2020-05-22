Class cls = Class.forName("TestEnum");
for (Object obj : cls.getEnumConstants()) {
   try {
       Method m = cls.getMethod("value", null);
       System.out.println(m.invoke(obj, null));
   } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
       System.out.println("could not find enum");
   }
}