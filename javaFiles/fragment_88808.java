import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;

@TestExecutionListeners(
    listeners = DirtyContextBeforeAndAfterClassTestExecutionListener.class, 
    mergeMode = MergeMode.MERGE_WITH_DEFAULTS
)
public class MyTest extends BaseTest { /* ... */ }