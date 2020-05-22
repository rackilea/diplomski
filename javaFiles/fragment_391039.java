//Arrange
B b_mock = Mockito.mock(B.class);
A a = new A(b_mock);
when(b_mock.bb).thenReturn(..something);

//Act
a.aa();

//...