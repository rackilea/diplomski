@Test
public void foo() {
    Runnable outer = Mockito.mock(Runnable.class, "outer");
    Runnable inner = Mockito.mock(Runnable.class, "inner");

    outer.run();
    inner.run();
    outer.run();

    InOrder order = Mockito.inOrder(outer, inner);
    order.verify(outer).run();
    order.verify(inner).run();
    order.verify(outer).run();
}