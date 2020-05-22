@RunWith(PowerMockRunner.class)
@PrepareForTest({A.class,B.class})
class TestA{
    B mb=EasyMock.createNiceMock(B.class); 
    PowerMock.expectNew(B.class).andReturn(mb).anyTimes();
    EasyMock.expect(mb.somefunction()).andReturn(0).anyTimes();
    EasyMock.replay(mb);
    PowerMock.replayAll();

    A a=new A(); //calling A's Constructor so that test case actually runs
}