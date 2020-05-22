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

    @Test(expected=RuntimeException.class)
    public void testMethod1Exception() throws Throwable {
        doThrow(new RuntimeException("bang!"))
                .when(mockActivities).method1();
        workflow.run();
    }
}