// Get class of the exception (with explicit "extends Exception")
Class<? extends Exception>clazz = (Class<? extends Exception>) Class.forName(exceptionClass);

// Get the constructor of the Exception class with a String as a parameter
Constructor<?> constructor = clazz.getConstructor(String.class);

// Instantiate and throw immediatly the new Exception
throw clazz.cast(constructor.newInstance(new Object[] { exceptionText }));