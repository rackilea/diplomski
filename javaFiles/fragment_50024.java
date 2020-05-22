// Obtain a class loader for the compiled classes
ClassLoader cl = fileManager.getClassLoader(CLASS_OUTPUT);
// Load the compiled class
Class compiledClass = cl.loadClass(CLASS_NAME);
// Find the eval method
Method myMethod = compiledClass.getMethod("myMethod");
// Invoke it
return myMethod.invoke(null);