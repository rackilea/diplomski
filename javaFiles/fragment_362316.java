C c = mock(C.class);
D d = mock(D.class); 
B b = mock(B.class);// Find a way to set private fields (May be provide setters).
A a = new A(b);

a.methodToTest();
verify(b).wantToVerifyThisIsCalled();