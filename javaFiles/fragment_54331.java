@Test
@ExtendWith(MockitoExtension.class) // @RunWith(MockitoJUnitRunner.class) for JUnit 4
class CollectorTest {
    @InjectMocks
    private Collector sut;

    @Mock
    private Formatter formatter;

    public FormattedData getFormattedData() {
        FormattedData formatted = mock(FormattedData.class);
        when(formatter.format(any()).thenReturn(formatted);

        FormattedData result = sut.getFormattedData();

        // verify injected formatter was called
        verify(formatter).format(any());
        // verify the result of the formatter is returned by the collector
        assertThat(result).isSameAs(formatted);
    }
}