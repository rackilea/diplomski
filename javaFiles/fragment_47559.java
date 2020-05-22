public interface IBar {
    void doPrimitiveStuff(int i);
}

verify(bar).doPrimitiveStuff(any()); // Compiles but throws NullPointerException
verify(bar).doPrimitiveStuff(anyInt()); // This is what you have to do instead