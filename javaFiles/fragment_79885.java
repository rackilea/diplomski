@RunWith(MockitoJUnitRunner.class)
public class RuleIdValidatorTest {
    @Mock
    private RuleStore ruleStoreMock;

    @InjectMocks
    private RuleIdValidator ruleIdValidator;

    @Test
    public void someTest() {
        when(ruleStoreMock.doSomething("arg")).thenReturn("result");

        String actual = ruleIdValidator.doSomeThatDelegatesToRuleStore();

        assertEquals("result", actual);
    }
}