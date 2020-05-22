FinalReflectionobj = new FinalReflection();
System.out.println(FinalReflection.stmark);
System.out.println(obj.inmark);
Field staticFinalField  = FinalReflection.class.getDeclaredField("stmark");
Field instanceFinalField  = FinalReflection.class.getDeclaredField("inmark");
staticFinalField.setAccessible(true);
instanceFinalField.setAccessible(true);

//EXTRA CODE
//Modify the final using reflection
Field modifiersField = Field.class.getDeclaredField("modifiers");
modifiersField.setAccessible(true);
modifiersField.setInt(staticFinalField, staticFinalField.getModifiers() & ~Modifier.FINAL);


instanceFinalField.set(obj, 100);
System.out.println(obj.inmark);
staticFinalField.set(FinalReflection.class, 101);
System.out.println(FinalReflection.stmark);