@RunWith(PowerMockRunner.class)
@PrepareForTest(CodeWithPrivateMethod.class)
public class PowerMock_Test {
    @Test(expected = RuntimeException.class)
    public void when_gambling_is_true_then_always_explode() throws Exception {
        CodeWithPrivateMethod spy = PowerMockito.spy(new CodeWithPrivateMethod());

        PowerMockito.doReturn(true).when(spy, "doTheGamble", anyString(), anyInt());


/* 1 */ PowerMockito.verifyPrivate(spy, times(0)).invoke("doTheGamble", anyString(), anyInt());            
        spy.meaningfulPublicApi();
/* 2 */ PowerMockito.verifyPrivate(spy, times(2)).invoke("doTheGamble", anyString(), anyInt());            
    }
}