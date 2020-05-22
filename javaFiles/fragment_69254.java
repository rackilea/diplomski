@RunWith(RobolectricTestRunner.class)
public class MyServiceTest {

    @Test
    public void someTest() {
        Robolectric.buildService(UpdateService.class)
            .attach()
            .create()
            .get()
            .getSystemService(Context.WINDOW_SERVICE);
    }

}