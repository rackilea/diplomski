// All exception handling omitted!
Class<?> enclosingClass = Class.forName("com.mycompany.Mother");
Object enclosingInstance = enclosingClass.newInstance();

Class<?> innerClass = Class.forName("com.mycompany.Mother$Child");
Constructor<?> ctor = innerClass.getDeclaredConstructor(enclosingClass);

Object innerInstance = ctor.newInstance(enclosingInstance);