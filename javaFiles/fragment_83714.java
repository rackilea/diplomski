final A mock = spy(new A());

final SOAPResponse response = mock(SOAPResponse.class);
final SOAPBody body = mock(SOAPBody.class);

// Order does not really matter, of course, but bottom up makes it clearer
// SOAPBody
when(body.whatever()).thenReturn(whatIsNeeded);

// SOAPResponse
when(response.getSoapBody()).thenReturn(body);

// Your A class
when(mock.getSoapResponse()).thenReturn(response);
when(mock.getAllProfiles("")).thenCallRealMethod();