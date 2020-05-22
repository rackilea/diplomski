@RunWith(RobolectricTestRunner.class)
public class WelcomeFragmentTest {
    @Test
    public void shouldNotBeNull() {
        WelcomeFragment fragment = WelcomeFragment.newInstance();
        startFragment(fragment);
        assertNotNull(fragment);
    }
}