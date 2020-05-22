common.jar:
BaseInterface

v1.jar:
SomeImplementation implements BaseInterface

v2.jar:
OtherImplementation implements BaseInterface

command-line:
java -classpath common.jar YourMainClass
// you don't put v1 nor v2 into the parent classloader classpath

Then in your program:

loader1 = new URLClassLoader(new URL[] {new File("v1.jar").toURL()}, Thread.currentThread().getContextClassLoader());
loader2 = new URLClassLoader(new URL[] {new File("v2.jar").toURL()}, Thread.currentThread().getContextClassLoader());

Class<?> c1 = loader1.loadClass("com.abc.Hello");
Class<?> c2 = loader2.loadClass("com.abc.Hello");

BaseInterface i1 = (BaseInterface) c1.newInstance();
BaseInterface i2 = (BaseInterface) c2.newInstance();