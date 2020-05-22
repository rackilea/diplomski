final int nrElements = myObjects.size();
final ArgumentCaptor<MyClass> captor = ArgumentCaptor.forClass(MyClass.class);

verify(theMock, times(nrElements)).add(captor.capture());

// This is using assertJ

assertThat(captor.getAllValues()).isEqualTo(myObjects);