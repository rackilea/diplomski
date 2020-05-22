import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.not;

@Test
public void hamcrestTest() throws Exception {
    List<String> list = Arrays.asList("b", "a", "c");
    List<String> shouldNotBeInList = Arrays.asList("a", "e", "f", "d");
    Assert.assertThat(list, everyItem(not(isIn(shouldNotBeInList))));
}