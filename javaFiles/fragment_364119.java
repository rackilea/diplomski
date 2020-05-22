import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class CompareListTest {

    @Test
    public void compareList() {
        List<String> expected = Arrays.asList("String A", "String B");
        List<String> actual = Arrays.asList("String B", "String A");

        assertThat("List equality without order", 
            actual, containsInAnyOrder(expected.toArray()));
    }

}