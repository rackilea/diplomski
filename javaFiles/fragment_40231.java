DrawTool mock = EasyMock.createMock(DrawTool.class);
EasyMock.checkOrder(mock, true);
mock.begin();
EasyMock.expectLastCall();
EasyMock.checkOrder(mock, false);
mock.end();
EasyMock.expectLastCall();
EasyMock.expect(mock.someOtherCallThatReturnsAValue()).andReturn(null);
EasyMock.checkOrder(mock, true);
mock.flush();
EasyMock.expectLastCall();
EasyMock.replay(mock);

new Drawer().draw(tool);

EasyMock.verify(mock);