@RunWith(PowerMockRunner.class)
@PrepareForTest({Instant.class})
public class InstantTest {

    public InstantTest() {
    }

    private Instant mock;

    @Before
    public void setUp() {
        PowerMockito.mockStatic(Instant.class);
        mock = PowerMockito.mock(Instant.class);
        PowerMockito.when(Instant.now()).thenReturn(mock);
    }

    @Test
    public void test() {
        Mockito.doReturn(76565766587L).when(mock).getEpochSecond();
        assertEquals(76565766587L, Instant.now().getEpochSecond());
    }
}