public class SampleTest {
    @Mock
    Second second;

    @InjectMocks
    Sample sample; //second will be injected here

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);            
    }

    @Test
    public void sampleMethodTest() {
        //Arrange
        String expected = "This should be displayed";
        when(second.show(any(String.class))).thenReturn(expected);

        //Act
        String actual = sample.sampleMethod();

        //Assert
        assertEquals(expected, actual);
    }
}