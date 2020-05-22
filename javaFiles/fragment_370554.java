@RunWith(ConcurrentTestRunner.class)
@Concurrent(count = 5)
public class ConcurrentTestRunnerTest {

    private static final Set<String> threads = synchronizedSet(new HashSet<String>());

    @Test
    public void test1() {
        // ...
    }
}