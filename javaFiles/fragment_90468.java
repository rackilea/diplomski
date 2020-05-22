@RunWith(PowerMockRunner.class)
@PrepareForTest({BusinessUtility.class})
public class BusinessUtilityTest {

    @Before
    public void setUp() {
        PowerMockito.mockStatic(BusinessUtility.class);
    }

    @Test
    public void testStatic() {
        when(BusinessUtility.getDate())
                         .thenReturn(new Date(1111))
                         .thenReturn(new Date(2222));

        assertThat(BusinessUtility.getDate()).hasTime(1111);
        assertThat(BusinessUtility.getDate()).hasTime(2222);
    }
}