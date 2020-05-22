String name = "com.mycompany.MyMainClass";

// Load the class dynamically
Class<?> mainClass = Class.forName(name);

// Find the 'main' method that takes a string array
Method mainMethod = mainClass.getMethod("main", new Class<?>[] { String[].class });

// Invoke the method; first arg is null, because the method is static
mainMethod.invoke(null, new String[] { "one", "two" });