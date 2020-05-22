// Obtain the unsafe object without throwing a SecurityException (assuming no security manager)
Field field = Unsafe.class.getDeclaredField("theUnsafe");
field.setAccessible(true);
Unsafe unsafe = (Unsafe) field.get(null);

// Create the instance 
MainClass instance = (MainClass) unsafe.allocateInstance(MainClass.class); // Constructor is not called

// set isRunning if needed
// do junit stuff