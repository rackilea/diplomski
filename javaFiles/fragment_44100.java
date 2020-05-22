@Test
public void thatYClassCanBeMocked() {
    final X mockX = createMock(X.class);
    final Y y = new Y(mockX);

    //Set up the list of B objects to return from the expectation
    final List<B> expectedReturnList = new List<B>();

    //Capture object for the list Of A objects to be used in the expectation
    final Capture<List<A>> listOfACapture = new Capture<List<A>>();

    //expectation that captures the list of A objects provided and returns the specified list of B objects
    EasyMock.expect( mockX.getListOfB( EasyMock.capture(listOfACapture) ) ).andReturn(expectedReturnList);

    //Replay the mock X instance
    EasyMock.replay(mockX);

    //Call the method you're testing
    final Z = y.getZ();

    //Verify the Mock X instance
    EasyMock.verify(mockX);

    //Get the captured list of A objects from the capture object
    List<A> listOfA = listOfACapture.getValue();

    //Probably perform some assertions on the Z object returned by the method too.
}