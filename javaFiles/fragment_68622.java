class Foo { protected void m() {} }
class Bar extends Foo {}
Foo actuallyBar = new Bar();
// This will throw NoSuchMethodException
// because m() is declared by Foo, not Bar:
actuallyBar.getClass().getDeclaredMethod("m");