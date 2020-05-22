//Arrange
MyObject svc = mock(MyObject.class);
MyObject2 svc2 = mock(MyObject2.class);

MyClass subject = new MyClass(svc, svc2);

Result response = mock(Result.class);
when(response.isEmpty()).thenReturn(false);

when(svc.getResponse()).thenReturn(response);

//Act
subject.getSvc();

//Assert
verify(svc2, times(1)).filterResponse(response); //verify method call inside void method