Object yourObject = ...;
Class clazz = yourObject.getClass();
Method setter = clazz.getMethod("setString", String.class); // You need to specify the parameter types
Object[] params = new Object[]{"New String"};
setter.invoke(this, params); // 'this' represents the class from were you calling that method.
// If you have a static method you can pass 'null' instead.