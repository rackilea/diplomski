MyClass objToPass = new MyClass();
Method m;
//Assuming functionCall() takes no arguments
m = MyClass.class.getMethod("functionCall", new Class[]{});
//Parameter list empty
m.invoke(objToPass, new Object[]{});