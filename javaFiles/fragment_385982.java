String text = "Test";
Kyle k = new Kyle();
Class clas = k.getClass();

// you'll need to handle exceptions from these methods, or throw them:
Method method = clas.getMethod(text, null);
method.invoke(k, null);