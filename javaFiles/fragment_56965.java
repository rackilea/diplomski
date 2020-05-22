// Decorates this with the spy.
MyClass mySpy = spy(this);
// Change behaviour of callWebservice method to return specific response
doReturn(mockResponse).when(mySpy).callWebservice(any(SomeWebServiceRequest.class));
// invoke the method to be tested.
instance.callDownstream(request);
// verify that callWebService has been called
verify(mySpy, times(1)).callWebService(any(SomeWebServiceRequest.class));