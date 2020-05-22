@RunWith(PowerMockRunner.class)
@PrepareForTest(Target.class)
public class Test {
    @Test
    public void doSomething() throws Exception {
        Member mockMember = mock(Member.class);
        PowerMockito.whenNew(Member.class).thenReturn(mockMember);
        Target thisTargetWillHaveYourMockAsField = new Target();
        //Your test code
    }
}