// method calling: mockedObject.someMethod(new Person("John"));
//...
ArgumentCaptor<Person> capture = ArgumentCaptor.forClass(Person.class);
verify(mockedObject).someMethod(capture.capture());
Person expected = new Person("John");
assertEquals("John", capture.getValue().getName());