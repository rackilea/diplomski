@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
public class MainActivityTest {
    @Test
    public void shouldCloseActivity() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        MenuItem menuItem = new RoboMenuItem(R.id.exit);
        activity.onOptionsItemSelected(menuItem);
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        assertTrue(shadowActivity.isFinishing());
    }
}