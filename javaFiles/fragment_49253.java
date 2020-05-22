long returnValue = 12;

Node nodeMock = createMock(Node.class);
expect(nodeMock.ixGet()).andReturn(returnValue);
replay(nodeMock);

//add test code here

verify(nodeMock);