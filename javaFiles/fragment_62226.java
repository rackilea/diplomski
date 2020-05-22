import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import com.googlecode.objectify.ObjectifyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RepositoryTest {
    // Tests under worst case of replication https://stackoverflow.com/questions/27727338/which-is-better-setdefaulthighrepjobpolicyunappliedjobpercentage100-vs-custo
    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig()
                .setDefaultHighRepJobPolicyUnappliedJobPercentage(100)); 

    private Closeable closeable;
    private Repository repository;

    @Before
    public void setup() {
        helper.setUp();
        repository = new Repository();
        ObjectifyService.register(MyCategory.class);
        ObjectifyService.register(MyItem.class);
        closeable = ObjectifyService.begin(); // https://stackoverflow.com/questions/27726961/how-to-resolve-you-have-not-started-an-objectify-context-in-junit
    }

    @After
    public void tearDown() {
        closeable.close();
        helper.tearDown();
    }

    @Test
    public void testLookupMyItemShouldSucceed() {
        MyCategory myCategory = repository.createMyCategory();

        int zero = 0;
        int one = 1;
        int two = 2;

        addMyItem(myCategory, zero, "a");
        MyItem expectedMyItem = addMyItem(myCategory, one, "b");
        addMyItem(myCategory, two, "c");

        MyItem actualMyItem = repository.lookupMyItem(myCategory, one);

        assertThat(actualMyItem, Matchers.notNullValue());
        assertThat(actualMyItem.id, equalTo(expectedMyItem.id));
    }

    private MyItem addMyItem(MyCategory myCategory, long index, String label) {
        MyItem myItem = repository.createMyItem();
        myItem.setParent(myCategory);
        myItem.setGroup(myCategory);
        myItem.index = index;
        myItem.label = label;
        repository.updateMyItem(myItem);
    }
}