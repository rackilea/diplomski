ClassA aObj = new ClassA();

// field access
Field field = ClassA.class.getDeclaredField("objectB");
Object bObj = field.getType().newInstance();
field.setAccessible(true); // as it is private it needs to be accessible first
field.set(aObj, bObj); // set bObj into field from aObj

// invoking method
Method method = bObj.getClass().getDeclaredMethod("methodB", String.class);
method.invoke(bObj, "reflection test!");