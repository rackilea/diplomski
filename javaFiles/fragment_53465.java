@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners(listeners = TestMethodScope.TestExecutionListener.class, 
        mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
public class MyTest {

    @Autowired
    // ... types annotated with @Scope("testMethod")

}