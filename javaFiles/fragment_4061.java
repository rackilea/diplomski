@RunWith(MockitoJUnitRunner.class)
public class MyFormTest {

    @InjectMocks
    private MyForm form = new MyForm();
    @Mock
    private FacilityValidationUtil facUtil;

    @Test
    public void testIsStopValid_false() {
        when(facUtil.isFacilityValid("")).thenReturn(false);
        assertEquals(false, form.isStopValid(""));
    }

    @Test
    public void testIsStopValid_true() {
        when(facUtil.isFacilityValid("")).thenReturn(true);
        assertEquals(true, form.isStopValid(""));
    }

    public class MyForm {
        private FacilityValidationUtil facUtil = new FacilityValidationUtil();

        public boolean isStopValid(String stop) {
            try {
                return facUtil.isFacilityValid(stop);
            } catch (FinderException e) {
                return false;
            }
        }
    }

    public class FacilityValidationUtil {
        public boolean isFacilityValid(String facility) throws FinderException {
            throw new RuntimeException(facility);
        }
    }

    public class FinderException extends RuntimeException {
        public FinderException(String message) {
            super(message);
        }
    }

}