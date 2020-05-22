class test {
    A mockA = mock(A.class);
    B mockB = mock(B.class);

    when(mockA.getB()).thenReturn(mockB);
    boolean b = mockA.getB() == null; // Should be false
}

interface A {
    B getB();
}

interface B {}