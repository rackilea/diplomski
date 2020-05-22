@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class ProcessXTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessXTest.class);

    private static final String BPMN_LOCATION = "./src/main/resources/processes/processx.bpmn";
    private static final String BPMN_NAME = "processx.bpmn";
    private static final String PROCESS_KEY = "processx";

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Before
    public void loadModel() throws FileNotFoundException {
        LOGGER.debug("Loading the model for unit testing.");

        Deployment deployment = repositoryService.createDeployment().addInputStream(BPMN_NAME, new FileInputStream(BPMN_LOCATION)).deploy();
        assertNotNull(deployment.getId());
        assertTrue(repositoryService.getDeploymentResourceNames(deployment.getId()).contains(bpmnName));
    }

    @Test
    public void testProcess() {
        LOGGER.debug("Unit testing the process.");

        List<Task> tasks = taskService.createTaskQuery().list();
        assertEquals(tasks.size(), 0);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY, new HashMap<String, Object>());
        assertNotNull(processInstance.getId());

        tasks = taskService.createTaskQuery().list();
        assertEquals(tasks.size(), 1);
    }
}