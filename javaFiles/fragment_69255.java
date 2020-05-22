@RunWith(RobolectricTestRunner.class)
public class MyServiceTest {

    @Test
    public void someTest() {
        Robolectric.buildService(UpdateService.class)
            .create()
            .get()
            .getSystemService(Context.WINDOW_SERVICE);
    }

}