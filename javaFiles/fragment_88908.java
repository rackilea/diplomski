public class MyServiceTests extends ServiceTestCase<MyService> {

private static final String TAG = "MyServiceTests";

public MyServiceTests() {
    super(MyService.class);
}

/**
 * Test basic startup/shutdown of Service
 */
@SmallTest
public void testStartable() {
    Intent startIntent = new Intent();
    startIntent.setClass(getContext(), MyService.class);
    startService(startIntent);
    assertNotNull(getService());
}

/**
 * Test binding to service
 */
@MediumTest
public void testBindable() {
    Intent startIntent = new Intent();
    startIntent.setClass(getContext(), MyService.class);
    IBinder service = bindService(startIntent);
    assertNotNull(service);
}
}