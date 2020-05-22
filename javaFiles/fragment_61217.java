// Straightforward parent class initializing
Class<?> cowClass = Class.forName("com.sample.Cow");
Object cowClassInstance = cowClass.newInstance();

// attempt to find the inner class
Class<?> oxClass = Class.forName("com.sample.Cow$Ox");

// Now find the instance of the inner class, you may need to pass in arguments for the constructor
Constructor<?> oxClassContructor = oxClass.getDeclaredConstructor(cowClass);

// initialize the inner instance using the parent class's (cow's) instance
Object oxClassInstance = oxClassContructor.newInstance(cowClassInstance);