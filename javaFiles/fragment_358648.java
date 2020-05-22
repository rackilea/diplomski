import org.junit.rules.ExternalResource;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class EmbeddedDataStore extends ExternalResource {
  private static LocalServiceTestHelper helper;

  @Override
  protected void before() throws Throwable {
    helper = new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig(),
      new LocalBlobstoreServiceTestConfig(), new LocalTaskQueueTestConfig(),
      new LocalMemcacheServiceTestConfig());
  }

  @Override
  protected void after() {
    helper.tearDown();
  }
}