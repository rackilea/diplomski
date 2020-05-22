@RunWith(FlowBlockJUnit4ClassRunner.class)
public class testWorkflow {
    @Rule
    public WorkflowTest workflowTest = new WorkflowTest();
    @Mock
    protected Activities mockActivities;

    @Before
    public void setUp() throws Exception {
        workflowTest.addActivitiesImplementation(mockActivities);
        workflowTest.addWorkflowImplementationType(Workflow.class);

        workflow = workflowFactory.getClient();
    }

    @Test
    public void testMethod1Exception() throws Throwable {
        doThrow(new RuntimeException("bang!"))
                .when(mockActivities).method1();
        new TryCatchFinally() {
           Throwable failure;

           protected void doTry() {
                workflow.run();
           }

           protected void doCatch(Throwable e) {
              failure = e;
           }

           protected void doFinally() {
              assertNotNull(failure);
           }
        };
    }
}